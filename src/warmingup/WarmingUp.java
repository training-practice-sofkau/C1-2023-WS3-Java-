package warmingup;

import java.util.*;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {

        /* TO DO:
        * Given a list of integers, use the Stream API to filter out even numbers, square the remaining numbers, and return the sum of the squared numbers.

        * Given a list of strings, use the Stream API to filter out strings that have a length greater than 5, convert the remaining strings to uppercase, and return a new list of the modified strings.

        * Given a list of strings, use the Stream API to group the strings by their length, and return a map where the keys are the lengths and the values are lists of strings with that length.

        * Given a list of strings, use the Stream API to group the strings by their first letter, and return a map where the keys are the first letters and the values are lists of strings that start with that letter.

        * Given a list of people, use the Stream API to group the people by their age, and return a map where the keys are the ages and the values are lists of people with that age.

        * Given a list of strings, use the Stream API to filter out strings that have a length less than 4, reverse the remaining strings, and return a new list of the modified strings.

        * Given a list of people, use the Stream API to filter out people who are older than 40, sort the remaining people by their age in descending order, and return a new list of the modified people.
*/


        //1
        System.out.println(squareSumNumbers(List.of(1,2,3,4,8)));

        //2
        greaterThanFive(List.of("even","splitter","odd","null","joy","kayak","fair","soccer","spider man","dexter")).forEach(System.out::println);

        //3
        System.out.println(lengthMap(List.of("apple","melon","pinneapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

        //4
        System.out.println(byFirstLetter(List.of("Diego","Daniel","Maria","Segio","Ivan","John","Jacob","Julian","Anna","Mariam")));

        //5
        System.out.println(
                peopleByAge(List.of(
                        new People("Diego",29,'M'),
                        new People("Marcela",30,'F'),
                        new People("Daniel",22,'M'),
                        new People("Andrea",18,'F'),
                        new People("Mark",22,'M'),
                        new People("Laura",29,'F'),
                        new People("Cletus",55,'M'),
                        new People("Robert",30,'M'),
                        new People("Demi",55,'F'),
                        new People("Jennifer",29,'F')

                ))
        );

        //6
        lessThanFourAndReverse(List.of("sun","aloha","red","diego","screen","cartoon","figures","food","paint","muscle","kid")).forEach(System.out::println);

        //
        System.out.println(
                peopleByOrderThan40(List.of(
                new People("Diego",29,'M'),
                new People("Marcela",44,'F'),
                new People("Daniel",22,'M'),
                new People("Andrea",41,'F'),
                new People("Mark",22,'M'),
                new People("Laura",29,'F'),
                new People("Cletus",55,'M'),
                new People("Robert",30,'M'),
                new People("Demi",55,'F'),
                new People("Jennifer",29,'F')

        )));

    }

    public static Map<Integer,List<String>> lengthMap(List<String> words){
        //First I need to know the length of the words
        return words.stream().collect(Collectors.groupingBy(String::length));

    }

    public static double squareSumNumbers(List<Integer> listNumbs){
        return listNumbs.stream().filter(n->n%2==0).map(even -> Math.pow(even,2)).reduce(0.0,Double::sum);
    }

    public static List<String> greaterThanFive(List<String> myStrings){

        return myStrings.stream().filter(s->s.length()>5).map(String::toUpperCase).collect(Collectors.toList());
    }

    public static Map<Character,List<String>> byFirstLetter(List<String> myStrings){

        return myStrings.stream().collect(Collectors.groupingBy(s->s.charAt(0),Collectors.mapping(String::valueOf,Collectors.toList())));
    }

    public static Map<Integer,List<People>> peopleByAge(List<People> myPeople){

        return myPeople.stream().collect(Collectors.groupingBy(People::getAge));
    }

    public static List<String> lessThanFourAndReverse(List<String> myStrings){
        return myStrings.stream().filter(s->s.length()<4).map(s-> new StringBuilder().append(s).reverse().toString() ).collect(Collectors.toList());
    }

    public static Map<Integer,List<People>> peopleByOrderThan40(List<People> myPeople){

        return myPeople.stream().filter(p->p.getAge()>40).collect(Collectors.groupingBy(People::getAge,TreeMap::new, Collectors.toList())).descendingMap();
    }


}
