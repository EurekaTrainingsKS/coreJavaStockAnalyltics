package eurekaAccounts.controller;

import eurekaAccounts.service.StockAnyaliticsService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockAnyalicitsController {
    public static void main(String[] args) throws SQLException {
        StockAnyaliticsService service = new StockAnyaliticsService();
        System.out.println("All sectors: " + service.getAllSectorsService());
        System.out.println("Sector 38: " + service.getASpecificSector());

        // Supply a ticker as a program argument, or run with the default AAPL.
        String ticker = args.length > 0 ? args[0] : "AAPL";
        System.out.println("Ticker lookup: " + service.getASpecificTickerSymbol(ticker));

        ArrayList<String> tickers = new ArrayList<>(List.of("AAPL", "TSLA", "NVDA"));
        System.out.println("Selected fundamentals: " + service.getStockFundamentals(tickers));
        System.out.println("All fundamentals count: " + service.getAllStockFundamentals().size());
        System.out.println("Healthcare stocks by market cap: " + service.getHealthCareStocks());

        System.out.println("Company locations for AAPL, TSLA, NVDA:");
        service.getCompanyLocations(tickers).forEach(System.out::println);

        System.out.println("IT stocks in descending market-cap order:");
        service.getAllITStocks().forEach(System.out::println);
    }
}
