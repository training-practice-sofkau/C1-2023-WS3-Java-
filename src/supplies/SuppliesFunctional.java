package supplies;


import supplies.sales.Customer;
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
                System.out.println(getNYSales());
                break;
            case "2":
                System.out.println(lessSatisfaction());
                break;
            case "3":
                System.out.println(allProducts());
                break;
            case "4":
                break;
            case "5":
                System.out.println(salesPerYear());
                break;
            default:
                System.out.println("Invalid input. Try again.");
        }

    }

    // 1st excercise
    public static Map<String, List<Sale>> getNYSales (){

        Map<String, List<Sale>> map1 = new HashMap<>();
        map1.put("Used", null);
        map1.put("No Used", null);
        map1.replace("Used", sales.stream().
                filter(i -> i.getLocation().equals("New York")).
                collect(Collectors.toList()).
                stream().filter(i->i.getCouponUsed()).collect(Collectors.toList()));
        map1.replace("No Used", sales.stream().
                filter(i -> i.getLocation().equals("New York")).
                collect(Collectors.toList()).
                stream().filter(i->!i.getCouponUsed()).collect(Collectors.toList()));
        return map1;
    }

    // 2nd excercise
    public static List<Customer> lessSatisfaction (){
        List <Customer> list = new ArrayList<>();
        sales.stream().sorted(Comparator.comparingInt(i-> i.getCustomer().getSatisfaction()))
                .forEach(i->list.add(i.getCustomer()));

        return list.stream().
                filter(i->i.getSatisfaction()==list.get(0).getSatisfaction()).
                collect(Collectors.toList());
    }
    // 3rd excercise
    public static Set<String> allProducts(){
        HashSet<String> map = new HashSet<>();
        sales.stream().flatMap(x->x.getItems().stream()).map(Product::getName).forEach(i->map.add(i));
        return map;
    }

    //5th excersice
    public static Map<Integer,List<Sale>> salesPerYear(){
        return sales.stream().collect(Collectors.groupingBy(i->i.getSaleDate().getYear()));
    }
}
