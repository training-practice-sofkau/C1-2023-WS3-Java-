package warmingup;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.lang.Math.pow;

public class WarmingUp {
    public static void main(String[] args) {

        System.out.println(lengthMap(List.of("apple","melon","pinneapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));




        // First exercise
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> total = numbers.stream().filter(i -> i%2 != 0).map(a -> a*a).reduce((a, b) -> a + b);
        System.out.println("The total is: " + total.get());

        // Second exercise


        /* TO DO:
        * Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

        * Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

        * Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.

        * Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        * Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/
    }

    public static Map<Integer,List<String>> lengthMap(List<String> words){
        //First I need to know the length of the words
        return words.stream().collect(Collectors.groupingBy(String::length));

    }




    }








