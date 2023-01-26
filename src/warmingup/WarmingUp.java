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
        System.out.println(lengthMap(List.of("apple","melon","pineapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

//      Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.
        System.out.println(firstLeterMap(List.of("apple","melon","pineapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

//      Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.
        ArrayList<People> persons = new ArrayList<>();
        persons.add(new People("Brian", 25, "M"));
        persons.add(new People("Natalia", 25, "F"));
        persons.add(new People("Felipe", 23, "M"));
        persons.add(new People("John", 70, "M"));
        persons.add(new People("Jeymmy", 35, "F"));
        persons.add(new People("Dante", 10, "M"));
        persons.add(new People("Franky", 15, "M"));
        persons.add(new People("Mercedes", 65, "F"));
        persons.add(new People("Maria", 51, "F"));
        persons.add(new People("Liliana", 90, "F"));

        System.out.println(ageMap(persons));

//      Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.
        System.out.println(lengtLess(List.of("app","melon","pin","mango","lemon","blueberry","banana","strawberry","kiw","mar","pitahaya")));

//      Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
        System.out.println(olderAgeMap(persons));
    }

    public static Integer sumEvenNum(List<Integer> integers) {
       return integers.stream().filter(n -> n % 2 == 0).map(i -> i * i).reduce(0, Integer::sum);
    }

    public static List<String> upCaseLength(List<String> words){
        return words.stream().filter(w -> w.length() > 5).map(String::toUpperCase).collect(Collectors.toList());
    }
    public static Map<Character,List<String>> firstLeterMap(List<String> words){
        return words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
    }
    public static Map<Integer,List<String>> lengthMap(List<String> words){
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static Map<Integer, List<People>> ageMap(ArrayList<People> people){
        return  people.stream().collect(Collectors.groupingBy(People::getAge));
    }

    public static List<StringBuilder> lengtLess(List<String> words){
        return words.stream().filter(w -> w.length() < 4).map(w -> new StringBuilder(w).reverse()).collect(Collectors.toList());
    }

    public static List<People> olderAgeMap(ArrayList<People> people){
        return  people.stream().filter(p -> p.getAge() > 40).sorted(Comparator.comparingInt(People::getAge).reversed()).collect(Collectors.toList());
    }
}
