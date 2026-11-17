package eurekaAccounts.DAO;

import eurekaAccounts.VO.SectorVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectorLookUpDAO extends BaseDAO {
    public ArrayList<SectorVO> getAllSectorsDAO() throws SQLException {
        return readSectors(null);
    }

    public ArrayList<SectorVO> getASpecificSector() throws SQLException {
        return readSectors(38);
    }

    private ArrayList<SectorVO> readSectors(Integer sectorId) throws SQLException {
        String sql = "SELECT sector_id, sector_name FROM endeavour.sector_lookup";
        if (sectorId != null) {
            sql += " WHERE sector_id = ?";
        }
        sql += " ORDER BY sector_id";
        ArrayList<SectorVO> sectors = new ArrayList<>();
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setQueryTimeout(15);
            if (sectorId != null) {
                statement.setInt(1, sectorId);
            }
            try (ResultSet rows = statement.executeQuery()) {
                while (rows.next()) {
                    sectors.add(new SectorVO(rows.getInt("sector_id"), rows.getString("sector_name")));
                }
            }
        }
        return sectors;
    }
}
