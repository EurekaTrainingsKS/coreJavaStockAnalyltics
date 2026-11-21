package eurekaAccounts.DAO;

import eurekaAccounts.VO.StockPriceHistoryVO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StockPriceHistoryDAO extends BaseDAO{
    public StockPriceHistoryDAO() {
    }

    public ArrayList<StockPriceHistoryVO> getSpecificStockHistory(String tickerSymbol, LocalDate fromDate, LocalDate toDate) throws SQLException {
        String sqlQurey = """
                select *
                from endeavour.stocks_price_history sph
                where sph.ticker_symbol = ?
                and sph.trading_date between ? and ?
                """;
        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sqlQurey);
        preparedStatement.setString(1,tickerSymbol);
        preparedStatement.setDate(2, Date.valueOf(fromDate));
        preparedStatement.setDate(3, Date.valueOf(toDate));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<StockPriceHistoryVO> specificStockHistory =  new ArrayList<>();
        while (resultSet.next()){
            StockPriceHistoryVO stockPriceHistoryVO =
                    new StockPriceHistoryVO(resultSet.getString("ticker_symbol"),
                            resultSet.getDate("trading_date").toLocalDate(),
                            resultSet.getBigDecimal("open_price"),
                            resultSet.getBigDecimal("close_price"),
                            resultSet.getBigDecimal("volume"));

            specificStockHistory.add(stockPriceHistoryVO);
        }
        return specificStockHistory;
    }
}
