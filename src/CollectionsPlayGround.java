import java.util.ArrayList;
import java.util.Collections;

public class CollectionsPlayGround {
    public static void main(String[] args) {
        ArrayList<String> tickersList = new ArrayList<>();
        tickersList.add("MSFT");
        tickersList.add("TSLA");
        tickersList.add("NVDA");
        tickersList.add("COSTCO");
        System.out.println(tickersList);
        System.out.println("Size of the tickers is " + tickersList.size());
        // Indexes start at 0, so index 3 is the fourth item.
        tickersList.remove(3);
        System.out.println(tickersList);

        ArrayList<String> tickerList2 = new ArrayList<>();
        System.out.println(tickerList2.isEmpty());
        tickerList2.add("INFY");
        tickerList2.add("IVLLY");

        // Insert the second list before the item at index 1.
        tickersList.addAll(1, tickerList2);
        System.out.println(tickersList);
        Collections.sort(tickersList);
        System.out.println("After sorting:" + tickersList);
    }
}
