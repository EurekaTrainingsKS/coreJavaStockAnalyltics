public class PassByValue {
    public static void main(String[] args) {
        Integer num = 10;
        System.out.println("Before Method Call");
        System.out.println("Num's Hash :"+System.identityHashCode(num));
        addValue(num);

        System.out.println("After Method Call");
        System.out.println("Num's hash :"+System.identityHashCode(num));
    }

    private static void addValue(Integer num) {
        System.out.println("In method before Updating");
        System.out.println("Num's hash :"+System.identityHashCode(num));
        //== till this both same values having 10, so they are diff copies of hash with same code
        num = num + 10;
        System.out.println("In method after Updating");
        System.out.println("Num's hash :"+System.identityHashCode(num));
    }
}
