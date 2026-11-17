package eurekaAccounts.VO;

public class StocksVO {
    private String tickerSymbol;
    private String tickerName;

    public StocksVO() {
    }

    @Override
    public String toString() {
        return "StocksVO{" +
                "tickerName='" + tickerName + '\'' +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                '}';
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }
}
