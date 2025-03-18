package programming;

import java.util.List;
import java.util.function.Supplier;

public class MethodReferences {

    private static void print(String str) {
        System.out.println(str);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");

        courses.stream()
                .map(String::toUpperCase) // Class instance methods
                .forEach(MethodReferences::print); // Can reference static method

        // Can create constructor reference
        Supplier<String> supplier = String::new;

    }
}