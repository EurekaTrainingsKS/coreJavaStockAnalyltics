package eurekaAccounts.VO;

public class CompanyLocationVO {
    private final String tickerSymbol;
    private final String address;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;

    public CompanyLocationVO(String tickerSymbol, String address, String city,
                             String state, String zip, String country) {
        this.tickerSymbol = tickerSymbol;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getTickerSymbol() { return tickerSymbol; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return "CompanyLocationVO{tickerSymbol='" + tickerSymbol
                + "', address='" + address + "', city='" + city
                + "', state='" + state + "', zip='" + zip
                + "', country='" + country + "'}";
    }
}
