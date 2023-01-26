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
                filterCouponInNY();
                break;
            case "2":
                topLessSatisfied();
                break;
            case "3":
                getSoldProducts ();
                break;
            case "4":
                gropByYear();
                break;
            case "5":

                break;
            default:
                System.out.println("Invalid input. Try again.");
        }

    }

    static Map<String, List<Sale>> filterCouponInNY() {
        Map<String, List<Sale>> salesList = sales.stream().filter(s -> s.getLocation().equals("New York")).collect(Collectors.groupingBy(s -> s.getCouponUsed() ? "Use" : "No use"));
        System.out.println("\nThese are the sales made in New York that used a coupon:\n");
        salesList.get("Use").forEach(s -> System.out.println("-- " + s.getLocation() + " -- Used coupon? " + s.getCouponUsed() + " - " + s.getCustomer() + ": "));
        System.out.println("\nAnd these are the sales made in New York that didn't used a coupon:\n");
        salesList.get("No use").forEach(s -> System.out.println("-- " + s.getLocation() + " -- Used coupon? " + s.getCouponUsed() + " - " + s.getCustomer() + ": "));
        return salesList;
    }

    static List<Customer> topLessSatisfied() {
        int worstQualification = Collections.min(sales.stream().map(Sale::getCustomer).map(Customer::getSatisfaction).collect(Collectors.toList()));
        System.out.println(worstQualification);
        List<Customer> customers = sales.stream().map(Sale::getCustomer).filter(customer -> customer.getSatisfaction() == worstQualification).collect(Collectors.toList());
        System.out.println("\nThese are the customers with the lowest satisfaction score:\n");
        customers.forEach(customer -> System.out.println("-- " + customer.getSatisfaction() + ": " + customer.getEmail()));
        return customers;
    }

    static TreeMap<Integer, List<Sale>> gropByYear() {
        TreeMap<Integer, List<Sale>> salesPerByYear = sales.stream()
                .sorted(Comparator.comparingInt(person -> (person.getSaleDate().getYear())))
                .collect(Collectors.groupingBy(sale -> sale.getSaleDate().getYear()))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, TreeMap::new));
        salesPerByYear.forEach((year, sale) -> {
            System.out.println("-- " + year + 1900 + ":\n\n");
            sale.forEach(sale1 -> System.out.println("-------> year: " + sale1.getSaleDate() + " " + sale1.getCustomer()));
        });
        return salesPerByYear;
    }
    static List<Product> getSoldProducts (){
        List<Product> soldProducts = sales.stream().flatMap(sale -> sale.getItems().stream()).collect(Collectors.toList());
        System.out.println("\nThese are the sold products :\n");
        soldProducts.forEach(product -> System.out.println("-- "+product.getName()));
        return soldProducts;
    }
}



