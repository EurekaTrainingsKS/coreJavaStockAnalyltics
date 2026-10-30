import java.util.Arrays;

public class Stringassignment02 {

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


        System.out.println("7. isEmpty / isBlank / trim / strip");
        String name = " ";   // one space
        String name1 = "";   // nothing at all
        System.out.println(name.isEmpty());   // false (it has 1 character: a space)
        System.out.println(name.isBlank());   // true  (only spaces)
        System.out.println(name1.isEmpty());  // true
        System.out.println(name1.isBlank());  // true
        String added = "   MSFT   ";
        System.out.println("[" + added.trim() + "]");          // [MSFT]
        System.out.println("[" + added.strip() + "]");         // [MSFT]
        System.out.println("[" + added.stripLeading() + "]");  // [MSFT   ]
        System.out.println("[" + added.stripTrailing() + "]"); // [   MSFT]


        System.out.println("8. Replace");
        System.out.println(ticker.replace("MSFT", "GOOG")); // replaces EVERY MSFT
        System.out.println(ticker.replace(',', ' '));       // replace a character


        // 9. Splitting one string into an array (and joining back)

        System.out.println("9. Split");
        String[] singleTickers = ticker.split(",");
        System.out.println(singleTickers.length);              // 5
        System.out.println(Arrays.toString(singleTickers));    // [TSLA, AMZN, MSFT, AMD, MSFT]
        for (String currentTicker : singleTickers) {          // for-each from ArraysPlayGround
            System.out.println(currentTicker + " has " + currentTicker.length() + " letters");
        }
        System.out.println(String.join("|", singleTickers));   // TSLA|AMZN|MSFT|AMD|MSFT


        // 10. Repeat, converting numbers, formatting

        System.out.println("10. repeat / valueOf / format");
        System.out.println("-".repeat(20));                    // --------------------
        int price = 250;
        String priceText = String.valueOf(price);              // int -> String
        System.out.println(priceText + 1);                     // 2501 (string joining, not math)
        int backToNumber = Integer.parseInt(priceText);        // String -> int
        System.out.println(backToNumber + 1);                  // 251 (real math)
        System.out.println(String.format("%s price is $%.2f", "AMD", 162.5)); // AMD price is $162.50


        // 11. Strings are IMMUTABLE (can't be changed)

        System.out.println("11. Immutability");
        String original = "tsla";
        original.toUpperCase();              // creates a NEW string, but we didn't save it
        System.out.println(original);        // tsla (unchanged!)
        original = original.toUpperCase();   // save the new string
        System.out.println(original);        // TSLA


        // 12. StringBuilder: a changeable string (good for loops)

        System.out.println("12. StringBuilder");
        StringBuilder sb = new StringBuilder("AMD");
        sb.append(" is a chip company");
        System.out.println(sb);              // AMD is a chip company
        System.out.println(new StringBuilder("TSLA").reverse()); // ALST


        // Small practice: count vowels in a name

        System.out.println("Practice: count vowel");
        String word = fullName.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            if ("aeiou".indexOf(word.charAt(i)) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }
       System.out.println("Total vowels: "+vowels);
       System.out.println("Total consonants: "+consonants);
}
}

