package eurekaAccounts.service;

import eurekaAccounts.DAO.SectorLookUpDAO;
import eurekaAccounts.DAO.StockFundamentalsDAO;
import eurekaAccounts.DAO.StockLookUpDAO;
import eurekaAccounts.VO.SectorVO;
import eurekaAccounts.VO.StockFundamentalsVO;
import eurekaAccounts.VO.StocksVO;

import java.util.ArrayList;
import java.util.Collections;

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
}
