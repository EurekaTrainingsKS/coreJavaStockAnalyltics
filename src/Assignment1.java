public class Assignment1 {
    public static void main(String[] args) {
        Stock TSLA = new Stock(589000,23,"TSLA",45,324);
        System.out.println(TSLA);
        Stock AMAZON = new Stock();
        AMAZON.setSectorId(34);
        AMAZON.setSubsectorId(129);
        AMAZON.setTickerSymbol("AAPL");
        AMAZON.setMarketcap(4000000);
        AMAZON.setCurrentRatio(34.00);
        System.out.println(AMAZON);
        Stock MSFT = createNewStock(68900,"MSFT",12,67,234);
        System.out.println(MSFT);
        Stock AMD = createNewStock(8903456,"AMD",6,92,567);
        System.out.println(AMD);
    }

    private static Stock createNewStock(int i, String msft, int i1, int i2, int i3) {
        return new Stock(i,i1,msft,i2,i3);
    }

}
