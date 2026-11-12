import eurekaAccounts.VO.SectorVO;
import eurekaAccounts.VO.SubSectorVO;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class JDBCPlayGround {
    public static void main(String[] args) throws IOException, SQLException {
        // db.properties belongs in the project root and is ignored by Git.
        Properties settings = new Properties();
        try (Reader reader = Files.newBufferedReader(Path.of("db.properties"))) {
            settings.load(reader);
        }

        DriverManager.setLoginTimeout(15);
        // try-with-resources closes the connection when this block finishes.
        try (Connection connection = DriverManager.getConnection(
                settings.getProperty("jdbc.url"),
                settings.getProperty("jdbc.user"),
                settings.getProperty("jdbc.password"))) {
            getAllSectors(connection);
            getAllSubSectors(connection);
        }
    }

    private static void getAllSubSectors(Connection connection) throws SQLException {
        String sqlQuery = """
                SELECT subsector_id, subsector_name, sector_id
                FROM endeavour.subsector_lookup
                ORDER BY subsector_id
                """;

        ArrayList<SubSectorVO> allSubSectors = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setQueryTimeout(15);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    SubSectorVO subSector = new SubSectorVO();
                    subSector.setSubSectorId(resultSet.getInt("subsector_id"));
                    subSector.setSubSectorName(resultSet.getString("subsector_name"));
                    // Integer preserves SQL NULL when a parent sector is absent.
                    subSector.setSectorId(resultSet.getObject("sector_id", Integer.class));
                    allSubSectors.add(subSector);
                }
            }
        }
        System.out.println("Subsectors retrieved: " + allSubSectors.size());
        System.out.println(allSubSectors);
    }

    private static void getAllSectors(Connection connection) throws SQLException {
        String sqlQuery = """
                SELECT sector_id, sector_name
                FROM endeavour.sector_lookup
                ORDER BY sector_id
                """;

        ArrayList<SectorVO> allSectors = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setQueryTimeout(15);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Each row becomes one Java object in the list.
                while (resultSet.next()) {
                    SectorVO sector = new SectorVO();
                    sector.setSectorId(resultSet.getInt("sector_id"));
                    sector.setSectorName(resultSet.getString("sector_name"));
                    allSectors.add(sector);
                }
            }
        }
        System.out.println(allSectors);
    }
}
