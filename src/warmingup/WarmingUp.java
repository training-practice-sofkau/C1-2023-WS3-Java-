package warmingup;

import java.util.*;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {

        /* TO DO:
        * 1. Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

        * 2. Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

        * 3. Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.

        * 4. Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        * 5. Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * 6. Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * 7. Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/
        //Ex1
        System.out.println("Exercise 1:");
        System.out.println(ex1EvenNumbers(List.of(1,2,1,2,1,2,1,2,1,10)));

        //Ex2
        System.out.println("Exercise 2:");
        System.out.println(ex2Strings2UpperCase(List.of("Hi","Helloo", "world","world!", "how", "how are", "u", "u doing?", "today", ".")));

        //Ex3
        System.out.println("Exercise 3:");
        System.out.println(ex3LengthMap(List.of("apple","melon","pinneapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

        //Ex4
        System.out.println("Exercise 4:");
        System.out.println(ex4FirstLetterMap(List.of("apple","melon","pinneapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));
    }

    //Exercise 1
    public static Integer ex1EvenNumbers(List<Integer> numbers ){
        return numbers.stream().filter(x -> x%2==0).map(x -> x*x).mapToInt(Integer::valueOf).sum();
    }

    //Exercise 2
    public static List<String> ex2Strings2UpperCase(List<String> strings){
        return strings.stream().filter(x -> x.length()>5).map(x-> x.toUpperCase()).collect(Collectors.toList());
    }

    //Exercise 3
    public static Map<Integer,List<String>> ex3LengthMap(List<String> words){
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    //Exercise 4
    public static Map<String,List<String>> ex4FirstLetterMap(List<String> words){
        return words.stream().collect(Collectors.groupingBy(s-> s.substring(0,1)));
    }
}
