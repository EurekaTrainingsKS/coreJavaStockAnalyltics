import java.util.Arrays;

public class StringAssignment {

    static String companyName = "INR Stocks";

    static {

        System.out.println("companyName is already set: " + companyName);
    }

    public static void main(String[] args) {

        String fname = "Nageswara Rao";
        String lname = "Innamuri";


        System.out.println("1.Joining strings");
        String fullName = fname + " " + lname;
        System.out.println(fullName);
        System.out.println(fname.concat(" ").concat(lname));    // using concat()
        System.out.println(String.join(" - ", "TSLA", "AMZN", "MSFT", "AMD")); // join many with a separator


        System.out.println("2. Length and reading characters");
        System.out.println(fname.length());       // 5
        System.out.println(fname.charAt(0));      // N  (index starts at 0)
        System.out.println(fname.charAt(fname.length() - 1)); // O (last character)
        System.out.println(fname.toCharArray());  // prints Nageswara Rao
        System.out.println(Arrays.toString(fname.toCharArray())); // [N, a, g, e, s, w, a, r, a,  , R, a, o]


        System.out.println("3. Searching inside a string");
        String ticker = "TSLA,AMZN,MSFT,AMD,MSFT";
        System.out.println(ticker.indexOf("MSFT"));     // 10 (first position)
        System.out.println(ticker.lastIndexOf("MSFT")); // 19 (last position)
        System.out.println(ticker.indexOf("GOOG"));     // -1 (not found)
        System.out.println(ticker.contains("AMD"));     // true
        System.out.println(ticker.startsWith("TSLA"));  // true
        System.out.println(ticker.endsWith("AMD"));     // false


        System.out.println("4. Substring");
        System.out.println(ticker.substring(5));     // AMZN,MSFT,AMD,MSFT (from index 5 to end)
        System.out.println(ticker.substring(0, 4));  // TSLA (start included, end NOT included)


        System.out.println("5. Upper / lower case");
        String stock = "Tesla Inc";
        System.out.println(stock.toUpperCase()); // TESLA INC
        System.out.println(stock.toLowerCase()); // tesla inc


        System.out.println("6. Comparing");
        String s1 = "TSLA";
        String s2 = "tsla";
        String s3 = new String("TSLA");
        System.out.println(s1.equals(s2));            // false (case matters)
        System.out.println(s1.equalsIgnoreCase(s2));  // true
        System.out.println(s1 == s3);                 // false (different objects)
        System.out.println(s1.equals(s3));            // true  (same content)
        System.out.println("AMD".compareTo("MSFT"));  // negative -> AMD comes before MSFT alphabetically
        System.out.println("MSFT".compareTo("AMD"));  // positive -> MSFT comes after AMD
        System.out.println("AMD".compareTo("AMD"));   // 0 -> equal
    }
}
