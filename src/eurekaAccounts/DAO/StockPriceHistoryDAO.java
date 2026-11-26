package eurekaAccounts.DAO;

import eurekaAccounts.VO.StockPriceHistoryVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class StockPriceHistoryDAO extends BaseDAO {
    public ArrayList<StockPriceHistoryVO> getSpecificStockHistory(
            String tickerSymbol, LocalDate fromDate, LocalDate toDate) throws SQLException {
        Objects.requireNonNull(tickerSymbol, "tickerSymbol");
        Objects.requireNonNull(fromDate, "fromDate");
        Objects.requireNonNull(toDate, "toDate");
        if (fromDate.isAfter(toDate)) {
            throw new IllegalArgumentException("fromDate must be on or before toDate.");
        }
        String sql = """
                SELECT ticker_symbol, trading_date, open_price, close_price, volume
                FROM endeavour.stocks_price_history
                WHERE ticker_symbol = ? AND trading_date BETWEEN ? AND ?
                ORDER BY trading_date
                """;
        ArrayList<StockPriceHistoryVO> history = new ArrayList<>();
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setQueryTimeout(15);
            statement.setString(1, tickerSymbol);
            statement.setDate(2, Date.valueOf(fromDate));
            statement.setDate(3, Date.valueOf(toDate));
            try (ResultSet rows = statement.executeQuery()) {
                while (rows.next()) {
                    history.add(new StockPriceHistoryVO(rows.getString("ticker_symbol"),
                            rows.getObject("trading_date", LocalDate.class),
                            rows.getBigDecimal("open_price"),
                            rows.getBigDecimal("close_price"),
                            rows.getBigDecimal("volume")));
                }
            }
        }
        return history;
    }
}
