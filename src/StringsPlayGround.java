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

    }
}
