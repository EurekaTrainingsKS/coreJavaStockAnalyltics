import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsPlayGround {
    public static void main(String[] args) {
        List<Integer> arrayList1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> arrayList2 = new ArrayList<>();
        for (Integer number : arrayList1) {
            arrayList2.add(number * number);
        }
        System.out.println("Squares using a loop: " + arrayList2);

        // map transforms each item; collect finishes the stream.
        List<Integer> squares = arrayList1.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println("Squares using a stream: " + squares);

        List<Integer> evens = arrayList1.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println("Even numbers: " + evens);

        List<Integer> descendingEvenSquares = arrayList1.stream()
                .map(number -> number * number)
                .filter(number -> number % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Even squares descending: " + descendingEvenSquares);

        String firstName = "Eureka";
        String lastName = null;
        Optional<String> firstNameOptional = Optional.ofNullable(firstName);
        firstNameOptional.ifPresent(name -> System.out.println("First name: " + name));
        System.out.println("Last name: " + Optional.ofNullable(lastName).orElse("Not provided"));

        Optional<Integer> sum = arrayList1.stream().reduce(Integer::sum);
        sum.ifPresent(total -> System.out.println("Sum: " + total));
    }
}
