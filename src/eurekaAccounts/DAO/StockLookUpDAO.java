package eurekaAccounts.DAO;

import eurekaAccounts.VO.StocksVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockLookUpDAO extends BaseDAO{
    public ArrayList<StocksVO> getASpecificTickerSymbol(String tickerSymbol){
        String sqlQurey = """
                select 
                    *
                    from
                        endeavour.stocks_lookup sl
                    where sl.ticker_symbol = ?;
                """;
        try {
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sqlQurey);
            preparedStatement.setString(1,tickerSymbol);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<StocksVO> allStocks = new ArrayList<>();
            while (resultSet.next()) {
                StocksVO stocksVO = new StocksVO();
                stocksVO.setTickerSymbol(resultSet.getString("ticker_symbol"));
                stocksVO.setTickerName(resultSet.getString("ticker_name"));
                allStocks.add(stocksVO);
            }
            return allStocks;
        }catch (SQLException e){
            System.out.println("failed to connect SectorLookUp table :"+e);
        }
        return null;
    }
}
