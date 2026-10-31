package my_work_src;

public class StringsPlayGround {
    public static void main(String[] args){
        String fname = "Sathwik ";
        String mname = "Reddy";
        String lname = "Ramidi";

        System.out.println("Length: " + fname.length());
        System.out.println("Uppercase: " + lname.toUpperCase());
        System.out.println("lowercase: " + lname.toLowerCase());
        System.out.println("Substring: " + lname.substring(0,3));
        System.out.println(fname.charAt(6));
        System.out.println(fname.concat(mname));
        System.out.println((fname+mname).indexOf("Reddy"));
        System.out.println((fname+mname).indexOf("e",3));
        System.out.println((fname+mname).lastIndexOf("d"));
        System.out.println(fname.equals("Sathwik "));
        System.out.println(lname.equalsIgnoreCase("ramidi"));
        System.out.println((fname+mname).compareTo("Sathwik Ramidi"));
        System.out.println((fname+mname).trim());//removes whitespaces
        System.out.println(mname.replace('d','x'));
        System.out.println((fname+mname).contains("Reddy"));
        System.out.println((fname+mname).startsWith("Sathwik"));
        StringBuilder builder = new StringBuilder("Sathwik Ramidi");
        builder.append("!");
        System.out.println(builder);
        builder.insert(7,",");
        System.out.println(builder.toString());
        System.out.println(builder);
        builder.delete(7,9);
        System.out.println(builder);
        char[] chars = fname.toCharArray();
        for(char c : chars){
            System.out.print(c + " ");
        }

    }
}
