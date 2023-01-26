package warmingup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarmingUp {
    public static void main(String[] args) {
        System.out.println(lengthMap(List.of("apple","melon","pinneapple","mango","lemon","blueberry","banana","strawberry","kiwi","maracuya","pitahaya")));

        System.out.println(filterEven(List.of(1,3,4,5,20,80,17,64,85,12,14)));
        System.out.println(filterEven(List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)));
        System.out.println(filterEven(List.of(2,2,4,66,8,4,86,76,24)));

        System.out.println(filterString(List.of("soup", "principle", "xbox", "exit", "abandon", "above",
                "academic", "accident", "accompany", "according", "accomplish")));
    }

    // First Excercise
    public static Integer filterEven (List<Integer> list){
        return list.stream().filter(i->i%2!=0).map(x->x*x).
                collect(Collectors.summingInt(Integer::intValue));
        //return null;
    }

    // Second excercise
    public static List<String> filterString(List<String> list){
        return list.stream().
                filter(i->i.length()>5).
                collect(Collectors.toList()).
                stream().map(i->i.toUpperCase()).
                collect(Collectors.toList());
    }
    public static Map<Integer,List<String>> lengthMap(List<String> words){
        //First I need to know the length of the words
        return words.stream().collect(Collectors.groupingBy(String::length));
    }
}
