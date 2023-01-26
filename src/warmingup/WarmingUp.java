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
        //System.out.println("1ST TASK -- Sum of even filtered numbers squared: "+sumOfSquaredFilteredList(intNumbers));

        //2nd
        List<String> strings = List.of("jonathan", "daniel", "music", "drive", "keyboard", "mouse", "standing", "car", "bikers", "ball", "measurement");
        //System.out.println("2ND TASK -- Filtered and capitalized strings: " + filterAndCapitalized(strings));

        //3rd
        //System.out.println("3RD TASK -- Group by length: "+lengthMap(List.of("apple","melon","pineapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","dragon fruit")));

        //4th
        System.out.println("4TH TASK -- Map group by first letter"+ sameFirstLetter(strings));
    }

    //method for the first task
    public static Integer sumOfSquaredFilteredList(List<Integer> numbers){
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(y->Math.pow(y,2))
                .mapToInt(Double::intValue)
                .sum();
    }

    //method for the second task
    public static List<String> filterAndCapitalized(List<String> strings){
        return strings.stream()
                .filter((x) -> x.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //method for the third task
    public static Map<Integer,List<String>> lengthMap(List<String> words){
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    //method for the fourth task
    public static Map<String,List<String>> sameFirstLetter(List<String> words){
        return words.stream().collect(Collectors.groupingBy( x -> String.valueOf(x.charAt(0))));
    }
}
