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
        //sales.forEach(System.out::println);
    }

    public static void loadProductsSold() {
        sales.stream()
                .flatMap(s -> s.getItems().stream())
                .collect(Collectors.toList())
                .stream()
                .map(Product::getName)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .forEach((k, values) -> System.out.println(k + ": " + values));
    }

    public static void amountProductsPerTag(){
        sales.stream()
                .flatMap(s->s.getItems().stream())
                .collect(Collectors.toList())
                .stream()
                .flatMap(p->p.getTags().stream())
                .collect(Collectors.groupingBy(String::valueOf,Collectors.counting()))
                .forEach((k, values) -> System.out.println(k + ": " + values));
    }

    public static void loadSalesPerYear(){
        sales.stream()
                .collect(Collectors.groupingBy(s -> "\n\n"+(s.getSaleDate().getYear()+1900)+"\n\n",TreeMap::new, Collectors.toList()))
                .descendingMap()
                .forEach((k, values) -> System.out.println(k + ": " + values));
    }


    public static void loadLowerScore(){
        Integer minScore = sales.stream()
                .mapToInt(n -> n.getCustomer().getSatisfaction())
                .min()
                .getAsInt();

        sales.stream()
                .filter(s -> s.getCustomer().getSatisfaction() == minScore)
                .sorted((s1, s2) -> String.CASE_INSENSITIVE_ORDER.compare(s1.getCustomer().getEmail(), s2.getCustomer().getEmail()))
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.getCustomer().getEmail() + " " + s.getCustomer().getSatisfaction()));
    }

    public static void loadNySales() {
        sales.stream()
                .filter(s -> Objects.equals(s.getLocation(), "New York"))
                .collect(Collectors.groupingBy(s -> s.getCouponUsed() ? "Use" : "No Use"))
                .forEach((k, values) -> System.out.println(k + ": " + values));
    }

    public static void loadMenu(){
        Scanner sc = new Scanner(System.in);
        menu();
        System.out.print("Type option: ");
        String op=sc.nextLine();
        switch(op){
            case "1":
                loadNySales();
                break;
            case "2":
                loadLowerScore();
                break;
            case "3":
                amountProductsPerTag();
                break;
            case "4":
                loadSalesPerYear();
                break;
            case "5":
                loadProductsSold();
                break;
            default:
                System.out.println("Invalid input. Try again.");
        }

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
}
