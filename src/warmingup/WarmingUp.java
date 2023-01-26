package warmingup;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WarmingUp {

    public static void main(String[] args) {
        List <People> persons = new ArrayList<>();
        persons.add(new People("Pedro", 32, "M"));
        persons.add(new People("María", 32, "F"));
        persons.add(new People("Jose", 44, "M"));
        persons.add(new People("Cristina", 28, "F"));
        persons.add(new People("Andrés", 45, "M"));
        persons.add(new People("Camilo", 28, "m"));
        persons.add(new People("Roberta", 15, "F"));
        persons.add(new People("Sofia", 15, "F"));
        persons.add(new People("Juan", 18, "M"));
        persons.add(new People("Carlos", 25, "M"));


        List<String> stringList = new ArrayList<>();
        stringList.add("red");
        stringList.add("black");
        stringList.add("blue");
        stringList.add("yellow");
        stringList.add("orange");
        stringList.add("pink");
        stringList.add("purple");
        stringList.add("brown");
        stringList.add("silver");
        stringList.add("white");


        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(10);

        /* TO DO:
        * Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers. */
        System.out.println("Ex 1: " + squaredNumbers(integerList));

        /*
        * Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings. */
        System.out.println("Ex 2: " + lengthUppercaseFilter(stringList));

        /*
        * Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.*/
        System.out.println("Ex 3: " + lengthMap(stringList));

        /*
        * Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.*/
        System.out.println("Ex 4: " + camelCaseString(stringList));

        /*
        * Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.*/
        System.out.println("Ex 5: " + peopleByAge(persons));

        /*
        * Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.*/
        System.out.println("Ex 6: " + lengthLessThan4(stringList));

        /*
        * Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.*/
        System.out.println("Ex 7: " + peopleOlderThan40(persons));

    }

    // public static Map<Integer,List<String>> newMap(List<String> words){}

    //Exercise 1
    public static int squaredNumbers (List<Integer> inputNumbers) {
        Predicate<Integer> isOdd = i -> i % 2 == 0;
        inputNumbers.removeIf(isOdd.negate());

        Integer result = inputNumbers.stream().
                map(a -> a * a).
                reduce(0, Integer::sum);

        return result;
    }

    // Exercise 2
    public static List<String> lengthUppercaseFilter(List<String> words){
        List<String> inputList = new ArrayList<>(words);

        Predicate<String> stringLength = i -> i.length() > 5;
        inputList.removeIf(stringLength.negate());


        return inputList.stream().map(a -> a.toUpperCase()).collect(Collectors.toList());
    }

    // Exercise 3
    public static Map<Integer,List<String>> lengthMap(List<String> words){
        List<String> inputList = new ArrayList<>(words);

        return inputList.stream().collect(Collectors.groupingBy(String::length));
    }

    // Exercise 4
    public static Map<Character, List<String>> camelCaseString (List<String> words) {
        List<String> inputList = new ArrayList<>(words);

        return inputList.stream().collect(Collectors.groupingBy(c -> c.charAt(0)));
    }

    //Ex 5
    public static Map<Integer, List<People>> peopleByAge (List<People> people) {
        List<People> inputList = new ArrayList<>(people);

        return inputList.stream().collect(Collectors.groupingBy(People::getAge));
    }

    //Ex 6
    public static List<String> lengthLessThan4(List<String> words){
        List<String> inputList = new ArrayList<>(words);

        return inputList.stream()
                .filter(a -> a.length() < 5)
                .map(a -> new StringBuilder(a).reverse().toString())
                .collect(Collectors.toList());
    }

    //Ex 7
    public static List<People>  peopleOlderThan40 (List<People> people) {
        List<People> inputList = new ArrayList<>(people);

        inputList = inputList.stream()
                .filter(a -> a.getAge() > 40)
                .collect(Collectors.toList());
        inputList.sort(Comparator.comparing(People::getAge));

        return inputList;
    }
}
