package eurekaAccounts.service;

import eurekaAccounts.DAO.CompanyLocationDAO;
import eurekaAccounts.DAO.SectorLookUpDAO;
import eurekaAccounts.DAO.StockFundamentalsDAO;
import eurekaAccounts.DAO.StockLookUpDAO;
import eurekaAccounts.VO.CompanyLocationVO;
import eurekaAccounts.VO.SectorVO;
import eurekaAccounts.VO.StockFundamentalsVO;
import eurekaAccounts.VO.StocksVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StockAnyaliticsService {
    public StockAnyaliticsService() {
    }
    SectorLookUpDAO sectorLookUpDAO = new SectorLookUpDAO();
    StockLookUpDAO stockLookUpDAO = new StockLookUpDAO();
    StockFundamentalsDAO stockFundamentalsDAO = new StockFundamentalsDAO();
    CompanyLocationDAO companyLocationDAO = new CompanyLocationDAO();

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

    public ArrayList<CompanyLocationVO> getCompanyLocations(ArrayList<String> tickerList) {
        return companyLocationDAO.getCompanyLocations(tickerList);
    }

    public ArrayList<StockFundamentalsVO> getAllStockFundamentals() {
        ArrayList<StockFundamentalsVO>  allStockFundamentals = stockFundamentalsDAO.getAllStockFundamentals();
        return allStockFundamentals;
    }

    public <StockFundamentalsVo> List<StockFundamentalsVo> getHealthCareStocks() {
        ArrayList<StockFundamentalsVO> allStockFundamentals = stockFundamentalsDAO.getAllStockFundamentals();
        List<StockFundamentalsVO> healthCareStockOnly
                = allStockFundamentals.stream()
                .filter(stock -> stock.getSectorId() == 34)
                .toList();
        long totalNumOfHealthCareStocks
                = allStockFundamentals.stream()
                .filter(stock -> stock.getSectorId() == 34)
                .count();

        return (List<StockFundamentalsVo>) healthCareStockOnly;
    }

    // IT = Technology sector (sector_id 37), sorted by market cap, biggest first
    public List<StockFundamentalsVO> getAllITStocks() {
        ArrayList<StockFundamentalsVO> allStockFundamentals = stockFundamentalsDAO.getAllStockFundamentals();
        return allStockFundamentals.stream()
                .filter(stock -> stock.getSectorId() == 37)
                .sorted(Comparator.comparing(StockFundamentalsVO::getMarketCap).reversed())
                .toList();
    }
}