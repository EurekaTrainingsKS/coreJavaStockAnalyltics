package eurekaAccounts.controller;

import eurekaAccounts.VO.CompanyLocationVO;
import eurekaAccounts.VO.StockFundamentalsVO;
import eurekaAccounts.service.StockAnyaliticsService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockAnyalicitsController {
    public static <StockFundamentalsVo> void main(String[] args) {

        StockAnyaliticsService allSectorsService = new StockAnyaliticsService();
        //ystem.out.println(allSectorsService.getAllSectorsService());



        //System.out.println(allSectorsService.getASpecificSector());


        //Scanner sc = new Scanner(System.in);// accepting something from system
        //System.out.println("Please enter required TickerSymbol for its tikcerName :");
        //String tickerSymbolSym = sc.nextLine(); //accepting an string
        //System.out.println(allSectorsService.getASpecificTickerSymbol(tickerSymbolSym));



        //ArrayList<String> tickerList = new ArrayList<>();
        //tickerList.add("AAPL");
        //tickerList.add("TSLA");
        //tickerList.add("NVDA");

        //System.out.println(allSectorsService.getStockFundamentals(tickerList));


        //ArrayList<String> locationTickers = new ArrayList<>();
        //locationTickers.add("AAPL");
        //locationTickers.add("TSLA");
        //locationTickers.add("NVDA");
        //for (CompanyLocationVO location : allSectorsService.getCompanyLocations(locationTickers)) {
         //   System.out.println(location);
        //}

        //Req getAllStockFundamentals
        ArrayList<StockFundamentalsVO> allStockFundamentals = allSectorsService.getAllStockFundamentals();
        //System.out.println(allStockFundamentals);

        //Req: get All Health care stocks,
        List<StockFundamentalsVO> healthCareStocks = allSectorsService.getHealthCareStocks();
        //System.out.println(healthCareStocks);


        List<StockFundamentalsVO> itStocks = allSectorsService.getAllITStocks();

        long itStockCount = itStocks.stream().count();

        BigDecimal totalITMarketCap = itStocks.stream()
                .map(StockFundamentalsVO::getMarketCap)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("IT stocks (highest market cap first):");
        itStocks.forEach(stock -> System.out.println(stock.getTickerSymbol() + " : " + stock.getMarketCap()));
        System.out.println("Total IT stocks : " + itStockCount);
        System.out.println("Total IT market cap : " + totalITMarketCap);



    }
}