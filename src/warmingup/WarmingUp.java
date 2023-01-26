package warmingup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {

        /* TO DO:
        * Exercise 1: Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

        * Exercise 2: Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

        * Exercise 3: Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.

        * Exercise 4: Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        * Exercise 5: Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * Exercise 6: Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * Exercise 7: Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/

        // Solving exercise 1:
        System.out.println(exercise1());

        // Solving exercise 2:
        System.out.println(exercise2());

        // Solving exercise 3:
        System.out.println(exercise3());

        // Solving exercise 4:
        System.out.println(exercise4());

        // Solving exercise 5:
        System.out.println(exercise5());

        // Solving exercise 6:
        System.out.println(exercise6());

        // Solving exercise 7:
        System.out.println(exercise7());
    }
    public static int exercise1() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        return numbers.stream()
                .filter(n -> n % 2 != 0) // filter out even numbers
                .map(n -> n * n) // square the remaining numbers
                .reduce(0, Integer::sum); // sum the squared numbers
    }

    public static List<String> exercise2(){

        List<String> strings = List.of("short", "less", "A bigger one", "A really big one", "The biggest one");

        return  strings.stream()
                .filter(s -> s.length() <= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static Map<Integer, List<String>>  exercise3() {
        List<String> strings = List.of("Juan", "Jose", "Jerry", "Thomas", "daddy","Kathie");
        return strings.stream().collect(Collectors.groupingBy(String::length));
    }

    private static boolean exercise4() {
        return false;
    }

    private static boolean exercise5() {
        return false;
    }

    private static boolean exercise6() {
        return false;
    }

    private static boolean exercise7() {
        return false;
    }

}


