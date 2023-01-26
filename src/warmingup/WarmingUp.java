package warmingup;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {
        List<String> stringsList = List.of("apple", "melon", "pinneapple", "mango", "lemon", "blueberry", "banana", "strawberry", "kiwi", "maracuya", "pitahaya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya", "aya");
        List<Integer> integersList = List.of(10, 15, 20, 25, 30, 27, 24, 21, 18, 15, 12, 9, 6, 3);
        List<People> peopleList = List.of(new People("Isan", 23, "M"),
                new People("Eduardo", 25, "M"),
                new People("Catalina", 27, "F"),
                new People("Lugel", 27, "M"),
                new People("Enrique", 17, "M"),
                new People("Maria", 53, "F"),
                new People("Luis", 53, "M"),
                new People("Samantha", 23, "F"),
                new People("Julian", 11, "M"),
                new People("Sara", 33, "F"));

        // * 1 Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

        solution1(integersList);

        // * 2 Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

        solution2(stringsList);

        // * 3 Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.

        lengthMap3(stringsList);

        // * 4 Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        groupByFirst4(stringsList);

        // * 5 Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        groupByAge5(peopleList);

        // * 6 Given a list of strings, use the Stream API to filter out strings that have a length lesser than 4, reverse the remaining strings, and return a new list of the modified strings.

        solution6(stringsList);

        // * 7 Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.

        filterOlderThanForty7(peopleList);

    }

    public static void solution1(List<Integer> numbers) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 1.");
        filterEven(numbers);
        filterOdd(numbers);
    }

    public static List<Integer> filterEven(List<Integer> numbers) {
        System.out.print("The list of even numbers is: [");
        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        evenNumbers.forEach(number -> System.out.print(number + ","));
        System.out.println("]");
        return evenNumbers;
    }

    public static Integer filterOdd(List<Integer> numbers) {
        Integer sumOfOddNumbersSquared = (numbers.stream().filter(number -> number % 2 != 0).map(number -> Math.pow(number, 2)).reduce(0.0, (Double::sum))).intValue();
        System.out.println("The sum of the odd numbers squared is: " + sumOfOddNumbersSquared);
        return sumOfOddNumbersSquared;
    }

    public static void solution2(List<String> words) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 2.\nThis is the list of the words with 5 or less characters:");
        filterShorterThanFive2(words);
        System.out.print("And these are the remaining words: ");
        filterLongerThanFive2(words);
    }

    private static List<String> filterShorterThanFive2(List<String> words) {
        List<String> moreThanFive = words.stream().filter(word -> word.length() <= 5).map(String::toUpperCase).collect(Collectors.toList());
        moreThanFive.forEach(word -> System.out.println("-- " + word + ": " + word.length()));
        return moreThanFive;
    }

    private static List<String> filterLongerThanFive2(List<String> words) {
        List<String> moreThanFive = words.stream().filter(word -> word.length() > 5).collect(Collectors.toList());
        moreThanFive.forEach(word -> System.out.print("(" + word + ": " + word.length() + ")"));
        System.out.println("");
        return moreThanFive;
    }


    public static Map<Integer, List<String>> lengthMap3(List<String> words) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 3.\nThis is the list of lists of words separated by their length:");
        Map<Integer, List<String>> mapOfWords = words.stream().collect(Collectors.groupingBy(String::length));
        mapOfWords.forEach((key, value) -> System.out.println("-- " + key + ": " + value));
        return mapOfWords;
    }

    public static Map<Character, List<String>> groupByFirst4(List<String> words) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 4.\nThis is the list of lists of words separated by their first letter:");
        Map<Character, List<String>> mapOfWords = words.stream().collect(Collectors.groupingBy((word) -> word.charAt(0)));
        mapOfWords.forEach((key, value) -> System.out.println("-- " + key + ": " + value));
        return mapOfWords;
    }

    public static Map<Integer, List<People>> groupByAge5(List<People> people) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 5.\nThis is the list of lists of persons separated by their age:");
        Map<Integer, List<People>> mapOfPeople = people.stream().collect(Collectors.groupingBy(People::getAge));
        mapOfPeople.forEach((key, list) -> System.out.println("-- " + key + ": " + list.stream().map(People::getName).collect(Collectors.toList())));
        return mapOfPeople;
    }

    public static void solution6(List<String> words) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 2.\nThis is the list of the words with 4 or more characters:");
        filterLongerThanFour6(words);
        System.out.print("And these are the remaining words: ");
        filterShorterThanFour6(words);
    }

    private static List<String> filterLongerThanFour6(List<String> words) {
        List<String> moreThanFive = words.stream().filter(word -> word.length() >= 4).map(word -> {
            StringBuilder newString = new StringBuilder(word);
            return newString.reverse().toString();
        }).collect(Collectors.toList());
        moreThanFive.forEach(word -> System.out.println("-- " + word + ": " + word.length()));
        return moreThanFive;
    }

    private static List<String> filterShorterThanFour6(List<String> words) {
        List<String> moreThanFive = words.stream().filter(word -> word.length() < 4).collect(Collectors.toList());
        moreThanFive.forEach(word -> System.out.print("(" + word + ": " + word.length() + ")"));
        System.out.println("");
        return moreThanFive;
    }
    public static List<People> filterOlderThanForty7(List<People> people) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSolution to exercise 5.\nThis is the list of lists of persons separated by their age:");
        List<People> mapOfPeople= people.stream().filter(person -> person.getAge()<=40).sorted(Comparator.comparingInt(person->(person.getAge())*-1)).collect(Collectors.toList());
        mapOfPeople.forEach((person) -> System.out.println("-- " + person.getName() + ": " + person.getAge()));
        return mapOfPeople;
    }
}