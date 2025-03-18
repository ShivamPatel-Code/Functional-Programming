package programming;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

public class BehaviorParameterization {

    public static void main(String[] args){

        List<Integer> numbers = List.of(5, 34, 23, 4, 45, 10, 34, 4, 6);
        predicateParameterization(numbers);
        functionParameterization(numbers);

    }

    private static void predicateParameterization(List<Integer> numbers) {

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Predicate<Integer> isOddPredicate = x -> x % 2 == 1;

        filterAndPrint(numbers, isEvenPredicate);
        filterAndPrint(numbers, isOddPredicate);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static void functionParameterization(List<Integer> numbers) {
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> cubeFunction = x -> x * x * x;
        Function<Integer, Integer> quadFunction = x -> x * x * x * x;

        System.out.println("Original List = " + numbers.stream().sorted().toList());

        Collection<Function<Integer, Integer>> functionList = List.of(squareFunction, cubeFunction, quadFunction);
        List<String> listName = List.of("Squared List = ", "Cube List = ", "Quad List = ");
        AtomicInteger i = new AtomicInteger();

        functionList
                .forEach(
                x -> {
                    List<Integer> temp  = BehaviorParameterization.getList(numbers, x);
                    System.out.println(listName.get(i.getAndIncrement()) + temp);
                });
    }

    private static List<Integer> getList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream()
                .map(function)
                .sorted()
                .toList();
    }

}
