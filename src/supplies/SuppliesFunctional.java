package supplies;


import supplies.sales.Customer;
import supplies.sales.Database;
import supplies.sales.Product;
import supplies.sales.Sale;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;


public class SuppliesFunctional {
    static ArrayList<Sale> sales = Database.loadDatabase();

    public static void main(String[] args) {
        loadMenu();
        //sales.forEach(System.out::println);

    }

    public static void menu() {
        System.out.println("Supplies sales");
        System.out.println("1. Sales located in NY that use / does not use a coupon");
        System.out.println("2. Customers that gives the lower satisfaction score.");
        System.out.println("3. Sold supplies");
        System.out.println("4. Sales categorized per year");
        System.out.println("5. Amount of products per tag");
        System.out.println("6. Exit");

    }

    public static void loadMenu() {
        Scanner sc = new Scanner(System.in);
        menu();
        System.out.print("Type option: ");
        String op = sc.nextLine();
            switch (op) {
                case "1":
                    System.out.println("Used and no used cupons: " + sales.stream()
                            .filter(s -> s.getLocation()
                                    .equals("New York"))
                            .collect(Collectors
                                    .groupingBy(sale -> sale.getCouponUsed() ? "Used: " : "Not Used: ", Collectors.mapping(Sale::getCustomer, Collectors.toList()))));
                    break;
                case "2":
                    Integer lessSatisfaction = sales.stream().min(Comparator.comparingInt(s -> s.getCustomer().getSatisfaction())).get().getCustomer().getSatisfaction();
                    System.out.println("Lower satisfaction: " + sales.stream()
                            .filter(o -> o.getCustomer().getSatisfaction() == lessSatisfaction)
                            .map(s -> s.getCustomer().getEmail())
                            .sorted()
                            .collect(Collectors.toList()));
                    break;
                case "3":
                    System.out.println("All the supplies sold: " + sales.stream()
                            .flatMap(s -> s.getItems()
                                    .stream()
                                    .map(Product::getName))
                            .distinct()
                            .sorted()
                            .collect(Collectors.toList()));
                    break;
                case "4":
                    System.out.println("Items per tag: " + sales.stream()
                            .flatMap(s -> s.getItems()
                                    .stream().distinct())
                            .collect(Collectors.toList())
                            .stream()
                            .flatMap(p->p.getTags().stream())
                            .collect(Collectors.groupingBy(String::valueOf,Collectors.counting())));
                    break;
                case "5":
                    System.out.println("Sales per year: " + sales.stream().collect(Collectors.groupingBy(s -> s.getSaleDate().getYear()+1900)).keySet());
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

    }


}
