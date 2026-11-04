import java.util.Objects;

public class Stock extends Object{
    private String tickerSymbol;
    private long marketCap;
    private double currentRatio;
    private int sectorId;
    private int subSectorId;//instance diff for diff objects
    private static String country = "USA"; //static variable same for all objects of Stock
    /**
     *why getters and setters layer of validation or security
     * Person class,.
     * private int age; (age can't be negtaive)
     */

    //single line comment
    /*
    multi line comments
     */
    /**
     * Documneted comments
     */
    /**
     * In java by default we will get a constructor with any params,
     * if we create on it will override the default constructor
     */
    public Stock(int sectorId, int subSectorId, String tickerSymbol, long marketCap, double currentRatio) {
        this.sectorId = sectorId;
        this.subSectorId = subSectorId;
        this.tickerSymbol = tickerSymbol;
        this.marketCap = marketCap;
        this.currentRatio = currentRatio;
    }

    public Stock(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public Stock() {

    }

    /**
     * how we compare objects,
     * for basic, String or Num we can dirrectly compare these values.
     * but for Objects we have multiple Parameters for Stock, tikcerSymbol, sectorId and soo...
     * so compare stock objects, we should tell java, take this specific param, by overriding equals method
     * if not by default just the hashCode of the Objects
     * @param o   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object o) {
       if(this.tickerSymbol == tickerSymbol) return true;
       else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickerSymbol, marketCap, currentRatio, sectorId, subSectorId);
    }

    @Override
    public String toString() {
        return "Stock{" +
                " sectorId=" + sectorId +
                ", subSectorId=" + subSectorId +
                ", currentRatio=" + currentRatio +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                ", marketCap=" + marketCap +
                '}';
    }

    public double getCurrentRatio() {
        return currentRatio;
    }
    public static void setCountry(String country){
        Stock.country = country;
    }

    public void setCurrentRatio(double currentRatio) {
        this.currentRatio = currentRatio;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public int getSectorId() {
        // can do some modification and return it.
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        if(sectorId>0){
            this.sectorId = sectorId;
        }else {
        }
    }

    public int getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(int subSectorId) {
        this.subSectorId = subSectorId;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }
    public static void main(String[] args) {
        // These are sample values for practice.
        Stock tesla = new Stock(1, 1, "TSLA", 1000000L, 2.5);

        Stock amazon = new Stock("AMZN");
        amazon.setSectorId(2);
        amazon.setSubSectorId(1);
        amazon.setMarketCap(2000000L);
        amazon.setCurrentRatio(1.8);

        Stock microsoft = new Stock();
        microsoft.setTickerSymbol("MSFT");
        microsoft.setSectorId(3);
        microsoft.setSubSectorId(1);
        microsoft.setMarketCap(3000000L);
        microsoft.setCurrentRatio(2.0);

        Stock amd = new Stock(3, 2, "AMD", 500000L, 1.5);

        System.out.println(tesla);
        System.out.println(amazon);
        System.out.println(microsoft);
        System.out.println(amd);

        System.out.println("Tesla ticker: " + tesla.getTickerSymbol());

        amd.setCurrentRatio(2.2);
        System.out.println("Updated AMD ratio: " + amd.getCurrentRatio());
    }
}
