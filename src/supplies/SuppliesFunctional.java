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
        sales.forEach(System.out::println);
        loadMenu();
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
                System.out.println(cuponNy(sales));
                break;
            case "2":
                System.out.println(lessSatisfaction(sales));
                break;
            case "3":
                System.out.println(soldSupl(sales));
                break;
            case "4":
                System.out.println(saleYear(sales));
                break;
            case "5":

                break;
            default:
                System.out.println("Invalid input. Try again.");
        }

    }


    public static Map<String, List<Sale>> cuponNy(ArrayList<Sale> sales){
        return sales.stream().filter(s -> Objects.equals(s.getLocation(), "New York"))
                .collect(Collectors.groupingBy(x -> x.getCouponUsed() ? "Use" : "No use"));
    }

    public static List<Customer> lessSatisfaction(ArrayList<Sale> sales){
        return sales.stream().map(Sale::getCustomer)
                .filter(customer -> customer.getSatisfaction().equals(1))
                .sorted(Comparator.comparing(Customer::getEmail)).collect(Collectors.toList());
    }

    public static List<String> soldSupl(ArrayList<Sale> sales){
        return sales.stream().flatMap(s -> s.getItems().stream())
                .map(Product::getName).distinct().collect(Collectors.toList());
    }

    public static Map<Integer, List<Sale>> saleYear(ArrayList<Sale> sales){
        return sales.stream().collect(Collectors.groupingBy(x -> x.getSaleDate().getYear() + 1900));
    }
//    public static OptionalInt lessSatisfactionNum(ArrayList<Sale> sales){
//        return sales.stream().mapToInt(x -> x.getCustomer().getSatisfaction()).min();
//    }


}
