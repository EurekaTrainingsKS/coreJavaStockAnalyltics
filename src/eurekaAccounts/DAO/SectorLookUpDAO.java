package eurekaAccounts.DAO;

import eurekaAccounts.VO.SectorVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectorLookUpDAO extends BaseDAO {
    public SectorLookUpDAO() {
    }

    public ArrayList<SectorVO> getAllSectorsDAO(){
        String sqlQurey = """
                select 
                    *
                    from
                        endeavour.sector_lookup;
                """;
        try {
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sqlQurey);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<SectorVO> allSectors = new ArrayList<>();
            while (resultSet.next()) {
                SectorVO sectorVO = new SectorVO();
                sectorVO.setSectorId(resultSet.getInt("sector_id"));
                sectorVO.setSectorName(resultSet.getString("sector_name"));
                allSectors.add(sectorVO);
            }
            return allSectors;
        }catch (SQLException e){
            System.out.println("failed to connect SectorLookUp table :"+e);
        }
        return null;
    }

    public ArrayList<SectorVO> getASpecificSector() {
        String sqlQurey = """
                select 
                    *
                    from
                        endeavour.sector_lookup sl where sl.sector_id = 38;
                """;
        try {
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sqlQurey);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<SectorVO> allSectors = new ArrayList<>();
            while (resultSet.next()) {
                SectorVO sectorVO = new SectorVO();
                sectorVO.setSectorId(resultSet.getInt("sector_id"));
                sectorVO.setSectorName(resultSet.getString("sector_name"));
                allSectors.add(sectorVO);
            }
            return allSectors;
        }catch (SQLException e){
            System.out.println("failed to connect SectorLookUp table :"+e);
        }
        return null;
    }
}