package warmingup;

import java.util.*;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {
//      Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.
        System.out.println(sumEvenNum(List.of(1, 2, 3, 4, 10, 55 , 88, 77, 44, 11, 466, 52, 99)));

//      Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.
        System.out.println(upCaseLength(List.of("apple","melon","pineapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

//      Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.
        System.out.println(firstLeterMap(List.of("apple","melon","pineapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

//      Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.
        System.out.println(lengthMap(List.of("apple","melon","pineapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

        /* TO DO:

        * Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/
    }


    public static Integer sumEvenNum(List<Integer> integers) {
       return integers.stream().filter(n -> n % 2 == 0).map(i -> i * i).reduce(0, Integer::sum);

    }

    public static List<String> upCaseLength(List<String> words){
        //First I need to know the length of the words
        return words.stream().filter(w -> w.length() > 5).map(String::toUpperCase).collect(Collectors.toList());

    }
    public static Map<Character,List<String>> firstLeterMap(List<String> words){
        //First I need to know the length of the words
        return words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

    }
    public static Map<Integer,List<String>> lengthMap(List<String> words){
        //First I need to know the length of the words
        return words.stream().collect(Collectors.groupingBy(String::length));

    }
}
