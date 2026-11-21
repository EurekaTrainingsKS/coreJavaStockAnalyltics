package eurekaAccounts.controller;

import eurekaAccounts.VO.StockFundamentalsVO;
import eurekaAccounts.service.StockAnyaliticsService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockAnyalicitsController {
    public static void main(String[] args) throws SQLException {
        //1st requirement is getAllSectors
        StockAnyaliticsService allSectorsService = new StockAnyaliticsService();
        //System.out.println(allSectorsService.getAllSectorsService());


        //2nd requirement is getASpecificSector number 38
       // System.out.println(allSectorsService.getASpecificSector());

        //3rd requirement now users wants to pass the ticker_symbol
        //Scanner sc = new Scanner(System.in);// accepting something from system
       // System.out.println("Please enter required TickerSymbol for its tikcerName :");
       // String tickerSymbolSym = sc.nextLine(); //accepting an string
       // System.out.println(allSectorsService.getASpecificTickerSymbol(tickerSymbolSym));

        //4th one is, user sends list of tickerSymbols we have to return their StockFundmentals

        ArrayList<String> tickerList = new ArrayList<>();
        tickerList.add("AAPL");
        tickerList.add("TSLA");
        tickerList.add("NVDA");

        //System.out.println(allSectorsService.getStockFundamentals(tickerList));

        //Req getAllStockFundamentals
        ArrayList<StockFundamentalsVO> allStockFundamentals = allSectorsService.getAllStockFundamentals();
        //System.out.println(allStockFundamentals);

        //Req: get All Health care stocks,
        List<StockFundamentalsVO> healthCareStocks = allSectorsService.getHealthCareStocks();
        //System.out.println(healthCareStocks);

        //Requiremnt is to get a specificPriceHistory for a specific tickerSymbol with from and to date
        String tickerSymbol = "TSLA";
        LocalDate fromDate = LocalDate.parse("2024-01-01");
        LocalDate toDate = LocalDate.parse("2024-01-10");
        System.out.println(allSectorsService.getSpecificStockHistory("TSLA",fromDate,toDate));


    }
}