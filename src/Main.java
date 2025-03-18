import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 34, 23, 645, 45, 45, 34, 34, 234);

        printFromStream(List.of("Spring", "Spring boot", "AWS", "Azure", "Python", "cpp"));
//        System.out.println("Sum of numbers = " + getSum(numbers));
        System.out.println("Sum of squares of numbers = " + sumOfSquares(numbers));

    }


    private static void printFromStream(List<String> courses){
        Function<String, String> toUpperCase = String::toUpperCase;
        Predicate<String> lengthPredicate = x -> x.length() > 3;
        Consumer<String> println = System.out::println;

        courses.stream()
                .filter(lengthPredicate)
                .sorted(Comparator.comparing(String::length))
                .map(toUpperCase)
                .forEach(println);

    }

    public static int sum(int aggregate, int nextNumber){
        return aggregate + nextNumber;
    }

    private static Integer getSum(List<Integer> numbers) {
        return numbers.stream()
//                .reduce(0, Main::sum);
//                .reduce(0, (x, y)->(x+y));
                .reduce(0, Integer::sum);
    }

    private static Integer sumOfSquares(List<Integer> numbers) {
//        return getSum(numbers.stream()
//                .map(x -> x*x)
//                .toList());

        return numbers.stream()
                .map(x -> x*x)
                .reduce(0, Integer::sum);
    }


}