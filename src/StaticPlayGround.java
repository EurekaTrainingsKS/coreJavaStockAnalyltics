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
    /*
     * Java initializes this class before calling its main method.
     * Static blocks run during class initialization, so "inside static"
     * prints before "inside main", even though the block is below main.
     *
     * Static blocks initialize data shared by the class.
     * They run once per class initialization, not for every new object.
     * Multiple static blocks in a class run in their source order.
     *
     * Other classes may initialize later when first actively used;
     * not every class's static blocks run before the program's main.
     */
    static { //static blocks
        System.out.println("inside static");
    }
}
