package eurekaAccounts.DAO;

import eurekaAccounts.VO.StocksVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockLookUpDAO extends BaseDAO {
    public ArrayList<StocksVO> getASpecificTickerSymbol(String tickerSymbol) throws SQLException {
        String sql = "SELECT ticker_symbol, ticker_name FROM endeavour.stocks_lookup WHERE ticker_symbol = ?";
        ArrayList<StocksVO> stocks = new ArrayList<>();
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setQueryTimeout(15);
            statement.setString(1, tickerSymbol);
            try (ResultSet rows = statement.executeQuery()) {
                while (rows.next()) {
                    StocksVO stock = new StocksVO();
                    stock.setTickerSymbol(rows.getString("ticker_symbol"));
                    stock.setTickerName(rows.getString("ticker_name"));
                    stocks.add(stock);
                }
            }
        }
        return stocks;
    }
}
