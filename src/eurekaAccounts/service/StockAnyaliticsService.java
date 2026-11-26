package eurekaAccounts.service;

import eurekaAccounts.DAO.SectorLookUpDAO;
import eurekaAccounts.DAO.StockPriceHistoryDAO;
import eurekaAccounts.VO.StockPriceHistoryVO;
import java.time.LocalDate;
import eurekaAccounts.DAO.CompanyLocationDAO;
import eurekaAccounts.VO.CompanyLocationVO;
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
    private final StockPriceHistoryDAO stockPriceHistoryDAO = new StockPriceHistoryDAO();

    public ArrayList<StockPriceHistoryVO> getSpecificStockHistory(
            String tickerSymbol, LocalDate fromDate, LocalDate toDate) throws SQLException {
        return stockPriceHistoryDAO.getSpecificStockHistory(tickerSymbol, fromDate, toDate);
    }
    private final CompanyLocationDAO companyLocationDAO = new CompanyLocationDAO();

    public List<CompanyLocationVO> getCompanyLocations(List<String> tickers) throws SQLException {
        return companyLocationDAO.getCompanyLocations(tickers);
    }

    public List<StockFundamentalsVO> getAllITStocks() throws SQLException {
        // The class database calls the IT sector Technology.
        int technologySectorId = getAllSectorsService().stream()
                .filter(sector -> "Technology".equalsIgnoreCase(sector.getSectorName()))
                .mapToInt(SectorVO::getSectorId)
                .findFirst()
                .orElseThrow(() -> new SQLException("Technology sector was not found."));
        List<StockFundamentalsVO> itStocks = getAllStockFundamentals().stream()
                .filter(stock -> Objects.equals(stock.getSectorId(), technologySectorId))
                .sorted(Comparator.comparing(StockFundamentalsVO::getMarketCap,
                        Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();
        BigDecimal totalMarketCap = itStocks.stream()
                .map(StockFundamentalsVO::getMarketCap)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("IT stock count: " + itStocks.size());
        System.out.println("Total known IT market cap: " + totalMarketCap.toPlainString());
        return itStocks;
    }
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
