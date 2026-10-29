public class Assignment2 {
    public static void main(String[] args) {
        String str = "Gopi";
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        String str2 = "Gopi Chand";
        System.out.println(str2.substring(6));
        System.out.println(str2.substring(0, 5));
        System.out.println(str2.split(" "));
        System.out.println(str2.indexOf("Chan"));
        System.out.println(str2.contains("opi"));
        System.out.println(str2.endsWith("and"));
        String s1 = "java";
        String s2 = "JAVA";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        String str3 = "  Gopi  ";
        System.out.println(str3.trim()); // Returns "Java"
        System.out.println(str3.toUpperCase()); // Returns "JAVA"
        System.out.println(str3.replace("p", "h"));
        System.out.println(String.valueOf(100)); // Returns "100"
        System.out.println(String.join("-", "2026", "10", "23"));

        //While loop
        int i = 0;
        while(i<10){
            System.out.println(i);
            i++;
        }

        //do while loop

        int j = 0;
        do{
            System.out.println(j*j);
            j++;
        }while(j<10);



    }
}
