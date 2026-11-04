public class ControlFlowPlayground {
    public static void main(String[] args) {


        String str1 = "Eureka";
        //System.out.println("length of string " + str1.length());

        Stock sampleStock = new Stock("TSLA");

        //randomStockInvestment(sampleStock);
        //randomStockInvestmentwithSwitch(sampleStock);
        //double randomdouble = Math.random();
        //String someString = randomdouble >0.5?"Greater":"lesser";
        //System.out.println(someString);

        Stock TSLA = new Stock(34,105,"Tsla",54099,1.5);
        Stock MSFT = new Stock(33,135,"MSFT",54599,2);
        System.out.println(TSLA.equals(MSFT));
    }

    private static void randomStockInvestmentwithSwitch(Stock sampleStock) {
        switch (sampleStock.getTickerSymbol()){
            case "TSLA":
                System.out.println("Sell it");break;
            case "MSFT":
                System.out.println("Hold it");break;
            case "NVDA":
                System.out.println("Buy it");break;
            default:
                System.out.println("Market is not Stable");
        }
    }

    private static void randomStockInvestment(Stock sampleStock){
        if(sampleStock.getTickerSymbol().equalsIgnoreCase("tsla")){
            System.out.println("don't hold, just sell");
        } else if(sampleStock.getTickerSymbol().equalsIgnoreCase("msft")){
            System.out.println("Hold it");
        } else if(sampleStock.getTickerSymbol().equalsIgnoreCase("nvda"))System.out.println("Buy more");
        else System.out.println("market is not stable");



    }

}
