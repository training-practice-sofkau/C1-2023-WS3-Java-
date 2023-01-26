package warmingup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {

        /* TO DO:
        * Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.
        */

        System.out.println("Sum of the square of odd numbers in list numbers: " + sumSquares(Data.numbers));

        /*
        * Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.
        */

        //System.out.println("\nOriginal list: " + Data.words + "\nFiltered list: " +longWordsFilter(Data.words) + "\n");

        /*
        * Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.
        */

        lengthMap(Data.words).forEach((key, values) -> System.out.println("" + key + values));

        /*
        * Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        * Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/
    }

    //public static Map<Integer,List<String>> lengthMap(List<String> words){
    //    //First I need to know the length of the words
    //    return words.stream()
    //            .collect(Collectors.groupingBy(String::length));
    //}

    public static List<String> longWordsFilter(List<String> words){

        return words.stream()
                .filter(s -> (s.length() <= 5))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static int sumSquares(List<Integer> numbers) {
        List<Integer> powNumbers = new ArrayList<Integer>();
        Integer result = 0;

        numbers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(n -> powNumbers.add((int) Math.pow(n, 2)));

        for (Integer n : powNumbers) {
            result += n;
        }

        return result;
    }

}
