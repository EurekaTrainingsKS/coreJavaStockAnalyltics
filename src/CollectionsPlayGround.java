import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionsPlayGround {
    public static void main(String[] args) {

        ArrayList<String> tickersList = new ArrayList<>();
        //we are calling ArrayList constrctor here.
        tickersList.add("MSFT");
        tickersList.add("TSLA");
        tickersList.add("NVDA");
        tickersList.add("COSTCO");
        System.out.println(tickersList);
        System.out.println("Size of the tickers is "+tickersList.size());
        tickersList.remove(3);
        System.out.println(tickersList);

        ArrayList<String> tickerList2 = new ArrayList<>();
        System.out.println(tickerList2.isEmpty());
        tickerList2.add("INFY");
        tickerList2.add("IVLLY");

        tickersList.addAll(1,tickerList2);
        System.out.println(tickersList);
        Collections.sort(tickersList);
        System.out.println("After sorting:"+tickersList);
    }
}
