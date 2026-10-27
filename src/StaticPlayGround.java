public class StaticPlayGround {
    public static void main(String[] args) {
        System.out.println("inside main");
        Stock tslaStock = new Stock();
        Stock.setCountry("USA");
        System.out.println(tslaStock);
        System.out.println(tslaStock.getTickerSymbol());
        Stock msft = new Stock();
        Stock.setCountry("IND");
        System.out.println(msft);
    }
    static { //static blocks
        System.out.println("inside static");
    }
}
