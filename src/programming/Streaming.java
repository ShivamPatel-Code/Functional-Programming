package programming;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Streaming {

    public static void main(String[] args){

        List<Integer> numbers = List.of(5, 34, 23, 645, 45, 45, 34, 34, 234);

        printFromStream(List.of("Spring", "Spring boot", "AWS", "Azure", "Python", "cpp"));
        System.out.println("Sum of numbers = " + getSum(numbers));
        System.out.println("Sum of squares of numbers = " + sumOfSquares(numbers));

        intStream();
    }


    private static void printFromStream(List<String> courses){
        Function<String, String> toUpperCase = String::toUpperCase;
        Predicate<String> lengthPredicate = x -> x.length() > 3;
        Consumer<String> println = System.out::println;

        courses.stream()
                .filter(lengthPredicate)
                .sorted(Comparator.comparing(String::length)) // can define comparator to sort
                .map(toUpperCase)
                .forEach(println);

    }

    public static int sum(int aggregate, int nextNumber){
        return aggregate + nextNumber;
    }

    private static Integer getSum(List<Integer> numbers) {
        return numbers.stream()
//                .reduce(0, programming.Main::sum);
//                .reduce(0, (x, y)->(x+y));
                .reduce(0, Integer::sum); // reduces a list into single object
    }

    private static Integer sumOfSquares(List<Integer> numbers) {
//        return getSum(numbers.stream()
//                .map(x -> x*x)
//                .toList()); Can return the updated list

        return numbers.stream()
                .map(x -> x*x)
                .reduce(0, Integer::sum);
    }

    private static void intStream() {
        System.out.println(IntStream.range(1, 10).sum());
        System.out.println(IntStream.rangeClosed(1, 10).sum());

        System.out.println(
                IntStream.iterate(2, e -> e + 2)
                        .limit(10)
//                        .peek(System.out::println)
                        .sum()
        );

        System.out.println(
                IntStream.iterate(2, e -> e + 2)
                        .limit(10)
//                        .peek(System.out::println)
                        .boxed()
                        .toList()
        );

        System.out.println(
                IntStream.rangeClosed(1, 50)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply)
        );
    }
}
