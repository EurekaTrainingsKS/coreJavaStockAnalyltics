package eurekaAccounts.DAO;

import eurekaAccounts.VO.CompanyLocationVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyLocationDAO extends BaseDAO {
    public ArrayList<CompanyLocationVO> getCompanyLocations(ArrayList<String> tickerList) {
        String sqlQuery = """
                select
                    *
                    from
                        endeavour.company_locations cl
                    where cl.ticker_symbol = ?
                """;
        ArrayList<CompanyLocationVO> allLocations = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sqlQuery);
            // run the same query once for every ticker in the list
            for (String ticker : tickerList) {
                preparedStatement.setString(1, ticker);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    CompanyLocationVO companyLocationVO = new CompanyLocationVO();
                    companyLocationVO.setTickerSymbol(resultSet.getString("ticker_symbol"));
                    companyLocationVO.setAddress(resultSet.getString("address"));
                    companyLocationVO.setCity(resultSet.getString("city"));
                    companyLocationVO.setState(resultSet.getString("state"));
                    companyLocationVO.setZip(resultSet.getString("zip"));
                    companyLocationVO.setCountry(resultSet.getString("country"));
                    allLocations.add(companyLocationVO);
                }
            }
        } catch (SQLException e) {
            System.out.println("failed to read company_locations table :" + e);
        }
        return allLocations;
    }
}
