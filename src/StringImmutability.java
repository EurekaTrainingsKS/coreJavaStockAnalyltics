public class StringImmutability {
    public static void main(String[] args) {
        //String are immutable and wrapper class(Integer's and so are also immutable)
        String name = new String("Kumar");
        //name string "Kumar" -hashCode(memory referenec) -> 01010100101
        System.out.println("HashCode of:"+name+" "+System.identityHashCode(name));
        //string is immutable
        name = name +"Eureka";
        System.out.println("HashCode after update :"+System.identityHashCode(name));

        System.out.println("===============");
        int num = 10;
        System.out.println(System.identityHashCode(num));
        num = num + 10;
        System.out.println(System.identityHashCode(num));

        /**
         * In memory
         * "Kumar" -> refrenec variable as name
         * "Kumar Eureka" -> repoint name to latest update
         */
    }
}
