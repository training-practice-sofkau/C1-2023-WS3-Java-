package warmingup;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarmingUp {
    public static void main(String[] args) {

        /*
         * 1 Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

         * 2 Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

         * 3 Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.
         *
         * 4 Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

         * 5 Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

         * 6 Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

         * 7 Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
         */

        List<Integer> intNumbers = List.of(1, 2, 5, 2, 6, 8, 3, 12, 34, 6, 7, 34, 56, 22, 4, 6, 7, 2, 12, 31, 23);
        List<String> strings = List.of("jonathan", "daniel", "music", "drive", "keyboard", "mouse", "standing", "car", "bikers", "ball", "measurement", "one", "run");

        People people1 = new People("Jonathan", 25, People.Gender.M);
        People people2 = new People("Sandra", 30, People.Gender.F);
        People people3 = new People("Antonio", 25, People.Gender.M);
        People people4 = new People("Jorge", 17, People.Gender.M);
        People people5 = new People("Mary", 20, People.Gender.F);
        People people6 = new People("Paola", 20, People.Gender.F);
        People people7 = new People("Camilo", 22, People.Gender.M);
        People people8 = new People("Harry", 25, People.Gender.F);
        People people9 = new People("Leo", 41, People.Gender.M);
        People people10 = new People("Andres", 41, People.Gender.M);
        People people11 = new People("Ban", 42, People.Gender.M);
        People people12 = new People("Sarah", 45, People.Gender.F);
        List<People> people = List.of(people1, people2, people3, people4, people5, people6, people7, people8, people9, people10, people11, people12);

        //1st
        System.out.println("1ST TASK -- Sum of even filtered numbers squared: " + sumOfSquaredFilteredList(intNumbers));

        //2nd
        System.out.println("2ND TASK -- Filtered and capitalized strings: " + filterAndCapitalized(strings));

        //3rd
        System.out.println("3RD TASK -- Group by length: " + lengthMap(List.of("apple", "melon", "pineapple", "mango", "lemon", "blueberry", "banana", "strawberry", "kiwi", "maracuya", "dragon fruit")));

        //4th
        System.out.println("4TH TASK -- Map group by first letter" + sameFirstLetter(strings));

        //5th
        System.out.println("5TH TASK -- Map group by Age: " + groupPeopleByAge(people));

        //6th
        System.out.println("6Th TASK -- List of reversed and filtered: " + filterAndReverse(strings));

        //7th
        System.out.println("7TH TASK -- List of sorted people with 40 years or more: " + filterAndSortPeople(people));
    }

    //method for the first task
    public static Integer sumOfSquaredFilteredList(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(y -> Math.pow(y, 2))
                .mapToInt(Double::intValue)
                .sum();
    }

    //method for the second task
    public static List<String> filterAndCapitalized(List<String> strings) {
        return strings.stream()
                .filter(x -> x.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //method for the third task
    public static Map<Integer, List<String>> lengthMap(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    //method for the fourth task
    public static Map<String, List<String>> sameFirstLetter(List<String> words) {
        return words.stream()
                .collect(Collectors
                        .groupingBy(x -> String.valueOf(x.charAt(0))));
    }

    //method for the fifth task
    public static Map<Integer, List<People>> groupPeopleByAge(List<People> people) {
        return people.stream().collect(Collectors.groupingBy(People::getAge));
    }

    //method for the sixth task
    public static List<String> filterAndReverse(List<String> strings) {
        return strings.stream()
                .filter(x -> x.length() < 4)
                .map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.toList());
    }

    //method for the seventh task
    public static List<People> filterAndSortPeople(List<People> people) {
        return people.stream()
                .filter(x -> x.getAge() > 40)
                .sorted(Comparator.comparing(People::getAge))
                .collect(Collectors.toList());
    }
}
