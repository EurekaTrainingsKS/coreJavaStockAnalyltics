package eurekaAccounts.DAO;

import eurekaAccounts.VO.StockFundamentalsVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StockFundamentalsDAO extends BaseDAO {
    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() throws SQLException {
        return readFundamentals(null);
    }

    public ArrayList<StockFundamentalsVO> getStockFundamentals(ArrayList<String> tickerList)
            throws SQLException {
        Objects.requireNonNull(tickerList, "tickerList");
        if (tickerList.isEmpty()) {
            return new ArrayList<>();
        }
        return readFundamentals(tickerList);
    }

    private ArrayList<StockFundamentalsVO> readFundamentals(List<String> tickerList)
            throws SQLException {
        String sql = "SELECT ticker_symbol, sector_id, subsector_id, market_cap, current_ratio"
                + " FROM endeavour.stock_fundamentals";
        if (tickerList != null) {
            // One placeholder per ticker keeps user values separate from SQL.
            String placeholders = String.join(", ", Collections.nCopies(tickerList.size(), "?"));
            sql += " WHERE ticker_symbol IN (" + placeholders + ")";
        }
        sql += " ORDER BY ticker_symbol";
        ArrayList<StockFundamentalsVO> stocks = new ArrayList<>();
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setQueryTimeout(15);
            if (tickerList != null) {
                for (int index = 0; index < tickerList.size(); index++) {
                    statement.setString(index + 1, tickerList.get(index));
                }
            }
            try (ResultSet rows = statement.executeQuery()) {
                while (rows.next()) {
                    StockFundamentalsVO stock = new StockFundamentalsVO();
                    stock.setTickerSymbol(rows.getString("ticker_symbol"));
                    stock.setSectorId(rows.getObject("sector_id", Integer.class));
                    stock.setSubSectorId(rows.getObject("subsector_id", Integer.class));
                    stock.setMarketCap(rows.getBigDecimal("market_cap"));
                    stock.setCurrentRatio(rows.getBigDecimal("current_ratio"));
                    stocks.add(stock);
                }
            }
        }
        return stocks;
    }
}
