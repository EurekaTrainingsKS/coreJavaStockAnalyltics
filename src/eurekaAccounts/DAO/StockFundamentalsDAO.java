package eurekaAccounts.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import eurekaAccounts.VO.StockFundamentalsVO;
public class StockFundamentalsDAO extends BaseDAO{
    public ArrayList<StockFundamentalsVO> getStockFundamentals(ArrayList<String> tickerList) {
        String sqlQurey = """
                select 
                    *
                    from
                        endeavour.stock_fundamentals sf 
                    where sf.ticker_symbol in ('TSLA','NVDA','AAPL')
                """;
        StringBuilder sqlQurey2 = new StringBuilder("""
                select
                        *
                        from
                endeavour.stock_fundamentals sf
                where sf.ticker_symbol in (
        """);
        for (int i=0;i< tickerList.size();i++){
            sqlQurey2.append("'");
            sqlQurey2.append(tickerList.get(i));
        }
        sqlQurey2.append(")");
        System.out.println(sqlQurey2);
//        for (int i=0; i<tickerList.size();i++){
//            sqlQurey.concat(tickerList.get(i)).concat("'");
//        }
//        sqlQurey.concat(")");
//        System.out.println(sqlQurey);
        try {
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(String.valueOf(sqlQurey));
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<StockFundamentalsVO> allStocks = new ArrayList<>();
            while (resultSet.next()) {
                StockFundamentalsVO stockFundamentalsVO = new StockFundamentalsVO();
                stockFundamentalsVO.setTickerSymbol(resultSet.getString("ticker_symbol"));
                stockFundamentalsVO.setSectorId(resultSet.getInt("sector_id"));
                stockFundamentalsVO.setSubSectorId(resultSet.getInt("subsector_id"));
                stockFundamentalsVO.setMarketCap(resultSet.getBigDecimal("market_cap"));
                stockFundamentalsVO.setCurrentRatio(resultSet.getBigDecimal("current_ratio"));
                allStocks.add(stockFundamentalsVO);
            }
            return allStocks;
        }catch (SQLException e){
            System.out.println("failed to connect SectorLookUp table :"+e);
        }
        return null;
    }
}