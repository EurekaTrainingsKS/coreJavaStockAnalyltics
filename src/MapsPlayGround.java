import java.util.HashMap;
import java.util.Map;

public class MapsPlayGround {
    public static void main(String[] args) {
        Map<String, String> mapOfStocks = new HashMap<>();
        // Each ticker is a key, and its practice message is the value.
        mapOfStocks.put("NVDA", "Buy it");
        mapOfStocks.put("TSLA", "sell it");
        mapOfStocks.put("COSCTO", "Hold it");
        System.out.println(mapOfStocks);

        String valueOfKey = mapOfStocks.get("TSLA");
        System.out.println(valueOfKey);
    }
}
