import eurekaAccounts.VO.SectorVO;

import java.sql.*;
import java.util.ArrayList;

public class JDBCPlayGround {
    private static String jdbcURL = "jdbc:postgresql://endeavourtech.ddns.net:50271/StocksDB";
    private static String userName = "evr_sql_app";
    private static String password = "5LViU5pLkSjRHECec9NF4wRxxV";
    public static void main(String[] args) throws SQLException {
        Connection jdbcConnection = DriverManager.getConnection(jdbcURL,userName,password);
        getAllSectors(jdbcConnection);
    }

    private static void getAllSectors(Connection jdbcConnection) throws SQLException {
        String sqlQurey = """
                select 
                    *
                    from
                        endeavour.sector_lookup;
                """;
        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sqlQurey);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<SectorVO> allSectors = new ArrayList<>();
        while (resultSet.next()){
            SectorVO sectorVO = new SectorVO();
            sectorVO.setSectorId(resultSet.getInt("sector_id"));
            sectorVO.setSectorName(resultSet.getString("sector_name"));
            allSectors.add(sectorVO);
        }
        System.out.println(allSectors);
    }
}
