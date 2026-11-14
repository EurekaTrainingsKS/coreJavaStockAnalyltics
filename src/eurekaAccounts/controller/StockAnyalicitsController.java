package eurekaAccounts.controller;

import eurekaAccounts.service.StockAnyaliticsService;

import java.util.ArrayList;
import java.util.Scanner;

public class StockAnyalicitsController {
    public static void main(String[] args) {
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

        System.out.println(allSectorsService.getStockFundamentals(tickerList));


    }
}