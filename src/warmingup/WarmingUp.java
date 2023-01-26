package warmingup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {

        /* TODO:
        * Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

        * Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

        * Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.
        *
        * Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        * Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/
        //1st
        List<Integer> intNumbers = List.of(1,2,5,2,6,8,3,12,34,6,7,34,56,22,4,6,7,2,12,31,23);
        System.out.println("Sum of even filtered numbers squared: "+sumOfSquaredFilteredList(intNumbers));
        //3rd
        //System.out.println(lengthMap(List.of("apple","melon","pinneapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));
    }

    public static Integer sumOfSquaredFilteredList(List<Integer> numbers){
        List<Integer> squared = new ArrayList<>();
        numbers.stream()
                .filter((x) -> x % 2 == 0)
                .forEach((y)-> squared.add((int) Math.pow(y,2)));
        System.out.println("List of even numbers squared: " + squared);
        return squared.stream().mapToInt(Integer::intValue).sum();
    }
    public static Map<Integer,List<String>> lengthMap(List<String> words){
        //First I need to know the length of the words
        return words.stream().collect(Collectors.groupingBy(String::length));

    }
}
