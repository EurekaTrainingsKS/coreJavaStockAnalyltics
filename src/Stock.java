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

    public Stock() {

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
}
