import java.util.Arrays;

public class ArraysPlayGround {
    public static void main(String[] args) {
        //arrays not arrayList's (collections)
        int[] intArray1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        //arrays are static in size, which increment with 0.7Xtimes of actual size. 10(5 spaces) (10+10X0.7) =
        //type[] Arrayname = new inttype{content}
        //index always starts at 0;
        int[] intArray2 =  new int[5];//creating with a size;

        System.out.println(intArray1[2]);
        System.out.println(intArray1.length);

        //Loops(for and for-each****)
        // assignemt while and do_while as practise
        int[] sqArray = new int[10];
        //intilization ,limit, increment
        for (int i=0; i<sqArray.length;i++){
            sqArray[i]=intArray1[i]*intArray1[i];
        }
        System.out.println(Arrays.toString(sqArray));

        //for each
        int i=0;
        int[] cubeArray = new int[10];
        for (int currentValue: intArray1){
            cubeArray[i] = currentValue*currentValue*currentValue;
            i++;
        }
        System.out.println(Arrays.toString(cubeArray));

        //for-each
        String[] tickers = new String[]{"APPL","TSLA","MSFT","NVDA"};
        for (String currentTicker : tickers){
            System.out.println(currentTicker);
        }


    }
}
