import java.util.Arrays;

public class StringsPlayGround {
    public static void main(String[] args) {
        String fname = "Kumar";// hardCoded the values
        String lname = "Eureka";
        String fNamelName = new String("");
        //string concatination
        String fullName = fname + " " + lname;
        System.out.println(fullName);
        String name = " ";//isEmpty
        String name1 = "";//isBlank true
        String tickerSymbols = "APPL,TSLA,GOOG,3MCARE"; //collection of strings into one single string
        System.out.println(tickerSymbols);
        //array of Strings
        String[] singleTikcers = tickerSymbols.split(",");
        System.out.println(singleTikcers.length);
        System.out.println(Arrays.toString(singleTikcers));

        System.out.println(fname.concat(" ").concat(lname));
        System.out.println(fname.equalsIgnoreCase(lname)); //these methods at Objects are instance,
        //methods at class level are static
        System.out.println(fname.equals(lname));
        System.out.println(fname.toCharArray());
        System.out.println(fname.length());
        System.out.println(fname.isEmpty());
        /**
         * microware.start(50wats)
         * kettel.start(30wats)
         * dishwasher.start(200wats)
         */
        System.out.println(fname.isBlank());
        System.out.println(fname.indexOf("K"));
        System.out.println(fname.charAt(2));

        //practise all the String methods form String Class.
        System.out.println("--- My string practice ---");

        String message = "Learning Java";

        System.out.println("Length: " + message.length());
        System.out.println("Uppercase: " + message.toUpperCase());
        System.out.println("Lowercase: " + message.toLowerCase());

        System.out.println("First character: " + message.charAt(0));
        System.out.println("First word: " + message.substring(0, 8));
        System.out.println("Contains Java: " + message.contains("Java"));
        System.out.println("Position of Java: " + message.indexOf("Java"));

        System.out.println("Starts with Learning: " + message.startsWith("Learning"));
        System.out.println("Ends with Java: " + message.endsWith("Java"));
        System.out.println("Replace: " + message.replace("Java", "Python"));

        String ticker = "TSLA";
        System.out.println("Exact match: " + ticker.equals("tsla"));
        System.out.println("Ignore case: " + ticker.equalsIgnoreCase("tsla"));

        String spaces = "   ";
        System.out.println("Spaces are empty: " + spaces.isEmpty());
        System.out.println("Spaces are blank: " + spaces.isBlank());

        String paddedTicker = "  MSFT  ";
        System.out.println("Trimmed: [" + paddedTicker.trim() + "]");

        String stocks = "TSLA,AMZN,MSFT,AMD";
        String[] symbols = stocks.split(",");
        System.out.println("Split tickers: " + Arrays.toString(symbols));

// String methods return results without changing the original string.
        System.out.println("Original message: " + message);

    }
}
