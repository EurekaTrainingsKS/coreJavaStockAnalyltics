package eurekaAccounts.controller;

import eurekaAccounts.VO.CompanyLocationVO;
import eurekaAccounts.service.StockAnyaliticsService;

import java.util.ArrayList;
import java.util.Scanner;

public class StockAnyalicitsController {
    public static void main(String[] args) {

        StockAnyaliticsService allSectorsService = new StockAnyaliticsService();
        System.out.println(allSectorsService.getAllSectorsService());



         System.out.println(allSectorsService.getASpecificSector());


        Scanner sc = new Scanner(System.in);// accepting something from system
        System.out.println("Please enter required TickerSymbol for its tikcerName :");
        String tickerSymbolSym = sc.nextLine(); //accepting an string
        System.out.println(allSectorsService.getASpecificTickerSymbol(tickerSymbolSym));



        ArrayList<String> tickerList = new ArrayList<>();
        tickerList.add("AAPL");
        tickerList.add("TSLA");
        tickerList.add("NVDA");

        System.out.println(allSectorsService.getStockFundamentals(tickerList));


        ArrayList<String> locationTickers = new ArrayList<>();
        locationTickers.add("AAPL");
        locationTickers.add("TSLA");
        locationTickers.add("NVDA");
        for (CompanyLocationVO location : allSectorsService.getCompanyLocations(locationTickers)) {
            System.out.println(location);
        }


    }
}