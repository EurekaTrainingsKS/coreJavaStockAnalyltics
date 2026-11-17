import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsPlayGround {
    public static void main(String[] args) {
        //we know, why streams got introduced
        //to remove usage of loops
        List<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        List<Integer> arrayList2 = new ArrayList<>(3);
        for(int i=0; i<arrayList1.size();i++){
            arrayList2.add(arrayList1.get(i)*arrayList1.get(i));
        }
        System.out.println("Sq's of ArrayList1: "+arrayList2);

        //streams
        List<Integer> integerList  = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Before mapping to there SQ's :"+integerList);
        //generating an list which holds the sq's integers
        //interating over the int's list to get sq's
        //intermediate and terminal operations
        List<Integer> sqList = integerList.stream().map(num -> num * num).collect(Collectors.toList());
                               //opening a stream on collections.
                                                   //map in an intermediate operation
                                                                                //collect is an terminal operation

        System.out.println("After mapping to there SQ's: "+sqList);

        //get the even's from intergers list
        //we can have multiple intermeditae operations, but only one terminal operation
        List<Integer> evensFromIntList = integerList.stream().filter(num -> {
            return num % 2 == 0;
        }).collect(Collectors.toList());
        System.out.println("Even form intList: "+evensFromIntList);

        //sq's of intList and only evens from that, and that be in desending order
        List<Integer> afterThreeOperations = integerList.stream().map(num -> num * num)//intermediate operations 1
                                                                .filter(num -> num % 2 == 0)//intermediate operations 2
                                                                .sorted(Comparator.comparing(Integer::intValue).reversed()) //intermediate operations 3
                                                                .toList(); //terminal operation.
        System.out.println("After three operations: "+afterThreeOperations);

        //Optional.. which defines may be or may not form DB
        String firstName = "Eureka";
        String lastName = null;
        Optional<String> fisrtNameOptional = Optional.ofNullable(firstName);
        try{
            System.out.println("FirstName is :"+fisrtNameOptional.get());
        }catch (NullPointerException e){
            System.out.println("Null Found");
        }

        //reduce, if sum of all intLists
        Optional<Integer> reduce = integerList.stream().reduce((int1, int2) -> int1 + int2);
        reduce.ifPresent(num-> System.out.println(reduce));

    }



















}
