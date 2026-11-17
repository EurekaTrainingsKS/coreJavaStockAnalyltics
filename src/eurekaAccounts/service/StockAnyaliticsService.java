package eurekaAccounts.service;

import eurekaAccounts.DAO.SectorLookUpDAO;
import eurekaAccounts.DAO.StockFundamentalsDAO;
import eurekaAccounts.DAO.StockLookUpDAO;
import eurekaAccounts.VO.SectorVO;
import eurekaAccounts.VO.StockFundamentalsVO;
import eurekaAccounts.VO.StocksVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StockAnyaliticsService {
    public StockAnyaliticsService() {
    }
    SectorLookUpDAO sectorLookUpDAO = new SectorLookUpDAO();
    StockLookUpDAO stockLookUpDAO = new StockLookUpDAO();
    StockFundamentalsDAO stockFundamentalsDAO = new StockFundamentalsDAO();

    public ArrayList<SectorVO> getAllSectorsService() {
        return sectorLookUpDAO.getAllSectorsDAO();
    }

    public ArrayList<SectorVO> getASpecificSector() {
        //basic need of service layer is for bussinessLogic
        return sectorLookUpDAO.getASpecificSector();
    }

    public ArrayList<StocksVO> getASpecificTickerSymbol(String tickerSymbolSym) {
        return stockLookUpDAO.getASpecificTickerSymbol(tickerSymbolSym);
    }

    public ArrayList<StockFundamentalsVO> getStockFundamentals(ArrayList<String> tickerList) {

        ArrayList<StockFundamentalsVO> stockFundamentals = stockFundamentalsDAO.getStockFundamentals(tickerList);
        return stockFundamentals;
    }

    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() {
        ArrayList<StockFundamentalsVO> allStockFundamentals = stockFundamentalsDAO.getAllStockFundamentals();
        return allStockFundamentals;
    }

    public List<StockFundamentalsVO> getHealthCareStocks() {
        ArrayList<StockFundamentalsVO> allStockFundamentals = stockFundamentalsDAO.getAllStockFundamentals();
        List<StockFundamentalsVO> healthCareStockOnly
                = allStockFundamentals.stream()
                                    .filter(stock -> stock.getSectorId() == 34)
                                    .toList();
        long totalNumOfHealthCareStocks
                = allStockFundamentals.stream()
                .filter(stock -> stock.getSectorId() == 34)
                .count();
        System.out.println("Total Count of healthCareStocks is :"+totalNumOfHealthCareStocks);

        List<StockFundamentalsVO> healthCareStocksByMarketCap = allStockFundamentals.stream()
                .filter(stock -> stock.getSectorId() == 34)
                .sorted(Comparator.comparing(
                        StockFundamentalsVO::getMarketCap,
                        Comparator.reverseOrder()
                ))
                .toList();

        //get total sum of marketCap for healthCareStocks
        Optional<BigDecimal> reduce = allStockFundamentals.stream().filter(stock -> stock.getSectorId() == 34)
                .map(StockFundamentalsVO::getMarketCap)
                .reduce((int1, int2) -> int1.add(int2));
        System.out.println("Total sum of all healthCareStocks is :"+reduce);

        return healthCareStocksByMarketCap;
    }
}
