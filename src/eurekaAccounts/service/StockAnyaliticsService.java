package eurekaAccounts.service;

import eurekaAccounts.DAO.SectorLookUpDAO;
import eurekaAccounts.DAO.StockFundamentalsDAO;
import eurekaAccounts.DAO.StockLookUpDAO;
import eurekaAccounts.VO.SectorVO;
import eurekaAccounts.VO.StockFundamentalsVO;
import eurekaAccounts.VO.StocksVO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// Name follows the classroom reference so its examples remain recognizable.
public class StockAnyaliticsService {
    private final SectorLookUpDAO sectorLookUpDAO = new SectorLookUpDAO();
    private final StockLookUpDAO stockLookUpDAO = new StockLookUpDAO();
    private final StockFundamentalsDAO stockFundamentalsDAO = new StockFundamentalsDAO();

    public ArrayList<SectorVO> getAllSectorsService() throws SQLException {
        return sectorLookUpDAO.getAllSectorsDAO();
    }

    public ArrayList<SectorVO> getASpecificSector() throws SQLException {
        return sectorLookUpDAO.getASpecificSector();
    }

    public ArrayList<StocksVO> getASpecificTickerSymbol(String tickerSymbol) throws SQLException {
        return stockLookUpDAO.getASpecificTickerSymbol(tickerSymbol);
    }

    public ArrayList<StockFundamentalsVO> getStockFundamentals(ArrayList<String> tickers)
            throws SQLException {
        return stockFundamentalsDAO.getStockFundamentals(tickers);
    }

    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() throws SQLException {
        return stockFundamentalsDAO.getAllStockFundamentals();
    }

    public List<StockFundamentalsVO> getHealthCareStocks() throws SQLException {
        List<StockFundamentalsVO> healthcareStocks = getAllStockFundamentals().stream()
                .filter(stock -> Objects.equals(stock.getSectorId(), 34))
                .sorted(Comparator.comparing(StockFundamentalsVO::getMarketCap,
                        Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();
        BigDecimal totalMarketCap = healthcareStocks.stream()
                .map(StockFundamentalsVO::getMarketCap)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Healthcare stock count: " + healthcareStocks.size());
        System.out.println("Total known healthcare market cap: " + totalMarketCap);
        return healthcareStocks;
    }
}
