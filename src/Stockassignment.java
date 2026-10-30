public class Stockassignment {
    public static void main(String[] args) {
        System.out.println("Assignment 01 - Stock Objects");

        System.out.println("Default constructor + setters");

        Stock tslaStock1 = new Stock();
        tslaStock1.setSectorId(25);
        tslaStock1.setSubSectorId(2510);
        tslaStock1.setTickerSymbol("TSLA");
        tslaStock1.setMarketCap(1000000);
        tslaStock1.setCurrentRatio(1.84);
        System.out.println(tslaStock1);

        Stock amznStock1 = new Stock();
        amznStock1.setSectorId(25);
        amznStock1.setSubSectorId(2550);
        amznStock1.setTickerSymbol("AMZN");
        amznStock1.setMarketCap(2200000);
        amznStock1.setCurrentRatio(1.05);
        System.out.println(amznStock1);

        Stock msftStock1 = new Stock();
        msftStock1.setSectorId(45);
        msftStock1.setSubSectorId(4510);
        msftStock1.setTickerSymbol("MSFT");
        msftStock1.setMarketCap(3500000);
        msftStock1.setCurrentRatio(1.27);
        System.out.println(msftStock1);

        Stock amdStock1 = new Stock();
        amdStock1.setSectorId(45);
        amdStock1.setSubSectorId(4530);
        amdStock1.setTickerSymbol("AMD");
        amdStock1.setMarketCap(250000);
        amdStock1.setCurrentRatio(2.62);
        System.out.println(amdStock1);


        // WAY 2: Parameterized constructor (all values in one line)

        System.out.println("WAY 2: Parameterized constructor");

        Stock tslaStock2 = new Stock(25, 2510, "TSLA", 1000000, 1.84);
        System.out.println(tslaStock2);

        Stock amznStock2 = new Stock(25, 2550, "AMZN", 2200000, 1.05);
        System.out.println(amznStock2);

        Stock msftStock2 = new Stock(45, 4510, "MSFT", 3500000, 1.27);
        System.out.println(msftStock2);

        Stock amdStock2 = new Stock(45, 4530, "AMD", 250000, 2.62);
        System.out.println(amdStock2);


        // WAY 3: Helper method with parameters

        System.out.println("WAY 3: Helper method with parameters");

        Stock tslaStock3 = creatStockObject(25, 2510, "TSLA", 1000000, 1.84);
        System.out.println(tslaStock3);

        Stock amznStock3 = creatStockObject(25, 2550, "AMZN", 2200000, 1.05);
        System.out.println(amznStock3);

        Stock msftStock3 = creatStockObject(45, 4510, "MSFT", 3500000, 1.27);
        System.out.println(msftStock3);

        Stock amdStock3 = creatStockObject(45, 4530, "AMD", 250000, 2.62);
        System.out.println(amdStock3);


        // WAY 4: Helper method without parameters + setters
        // (same method name, no params = method overloading)

        System.out.println("WAY 4: Helper method without parameters + setters");

        Stock tslaStock4 = creatStockObject();
        tslaStock4.setSectorId(25);
        tslaStock4.setSubSectorId(2510);
        tslaStock4.setTickerSymbol("TSLA");
        tslaStock4.setMarketCap(1000000);
        tslaStock4.setCurrentRatio(1.84);
        System.out.println(tslaStock4);

        Stock amznStock4 = creatStockObject();
        amznStock4.setSectorId(25);
        amznStock4.setSubSectorId(2550);
        amznStock4.setTickerSymbol("AMZN");
        amznStock4.setMarketCap(2200000);
        amznStock4.setCurrentRatio(1.05);
        System.out.println(amznStock4);

        Stock msftStock4 = creatStockObject();
        msftStock4.setSectorId(45);
        msftStock4.setSubSectorId(4510);
        msftStock4.setTickerSymbol("MSFT");
        msftStock4.setMarketCap(3500000);
        msftStock4.setCurrentRatio(1.27);
        System.out.println(msftStock4);

        Stock amdStock4 = creatStockObject();
        amdStock4.setSectorId(45);
        amdStock4.setSubSectorId(4530);
        amdStock4.setTickerSymbol("AMD");
        amdStock4.setMarketCap(250000);
        amdStock4.setCurrentRatio(2.62);
        System.out.println(amdStock4);

        // Getters: read one value from an object

        System.out.println("Getters");
        System.out.println(tslaStock1.getTickerSymbol() + " market cap: " + tslaStock1.getMarketCap());
        System.out.println(amznStock2.getTickerSymbol() + " current ratio: " + amznStock2.getCurrentRatio());
        System.out.println(msftStock3.getTickerSymbol() + " sector id: " + msftStock3.getSectorId());
        System.out.println(amdStock4.getTickerSymbol() + " sub sector id: " + amdStock4.getSubSectorId());


        // Validation in setter: sectorId can't be negative

        System.out.println("Validation in setter");
        amdStock1.setSectorId(-10); // rejected by the if(sectorId>0) check
        System.out.println("AMD sector id after trying -10: " + amdStock1.getSectorId());


        // Static variable: changed once for ALL Stock objects

        Stock.setCountry("United States");
    }

    // Helper method with parameters -> uses parameterized constructor
    private static Stock creatStockObject(int sectorId, int subSectorId, String tickerSymbol, int marketCap, double currentRatio) {
        return new Stock(sectorId, subSectorId, tickerSymbol, marketCap, currentRatio);
    }

    // Helper method without parameters -> uses default constructor
    private static Stock creatStockObject() {
        return new Stock();
    }
}
