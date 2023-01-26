package supplies;


import supplies.sales.Database;
import supplies.sales.Product;
import supplies.sales.Sale;

import java.util.*;
import java.util.stream.Collectors;


public class SuppliesFunctional {
    static ArrayList<Sale> sales = Database.loadDatabase();
    public static void main(String[] args) {
        loadMenu();
//        sales.forEach(System.out::println);

    }

    public static void menu(){
        System.out.println("Supplies sales");
        System.out.println("1. Sales located in NY that use / does not use a coupon");
        System.out.println("2. Customers that gives the lower satisfaction score.");
        System.out.println("3. Sold supplies");
        System.out.println("4. Sales categorized per year");
        System.out.println("5. Amount of products per tag");
        System.out.println("6. Exit");

    }

    public static void loadMenu(){
        Scanner sc = new Scanner(System.in);
        menu();
        System.out.print("Type option: ");
        String op=sc.nextLine();
        switch(op){
            case "1":
                Map<String, List<Sale>> result1 = case1();
                result1.forEach((key, value) -> System.out.println(key + ","+ value));
                break;
            case "2":
                List<Sale> result2 = case2();
                result2.forEach(System.out::println);
                break;
            case "3":
                List<String> result3 = case3();
                result3.forEach(System.out::println);
                break;
            case "4":
                Map<Date, List<Sale>> result4 = case4();
                result4.forEach((key, value) -> System.out.println(key + ","+ value));
                break;
            case "5":
                case5();
                break;
            case "6":
                break;
            default:
                System.out.println("Invalid input. Try again.");
        }
    }

    public static Map<String, List<Sale>> case1() {

        return sales.stream()
                .filter(s -> s.getLocation().equals("New York"))
                .collect(Collectors.groupingBy(s -> Boolean.TRUE.equals(s.getCouponUsed()) ? "Use" : "No use"));
    }

    public static List<Sale> case2() {

        return sales.stream()
                .filter(s -> s.getCustomer().getSatisfaction() < 2 )
                .sorted((s1, s2) -> s2.getCustomer().getAge() - s1.getCustomer().getAge())
                .collect(Collectors.toList());
    }

    public static List<String> case3() {

        return sales.stream()
                .flatMap(sale -> sale.getItems().stream())
                .map(Product::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Map<Date, List<Sale> > case4() {

        return sales.stream().
                collect(Collectors.groupingBy(Sale::getSaleDate));
    }

    public static void case5() {

    }
}
