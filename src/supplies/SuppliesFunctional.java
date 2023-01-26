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
        //loadMenu();
        //sales.forEach(System.out::println);

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
                //System.out.println(ex1SalesNY(sales));
                break;
            case "2":
                System.out.println(ex2CustomerSat(sales));
                break;
            case "3":

                break;
            case "4":

                break;
            case "5":

                break;
            default:
                System.out.println("Invalid input. Try again.");
        }

    }

    public static Map<Boolean, List<Sale>> ex1SalesNY (List<Sale> salesNY) {
        //issue renaming keys
        return salesNY.stream().collect(Collectors.groupingBy(Sale::getCouponUsed));

                //Map<Boolean, List<Sale>> temp = salesNY.stream().collect(Collectors.groupingBy(Sale::getCouponUsed));
    }

    public static List<Customer> ex2CustomerSat (List<Sale> salesNY) {
        OptionalInt lessSat = salesNY.stream().map(sale -> sale.getCustomer().getSatisfaction()).mapToInt(Integer::valueOf).min();
        return salesNY.stream()
                .map(sale -> sale.getCustomer())
                .filter(customer -> customer.getSatisfaction()==lessSat.getAsInt())
                .collect(Collectors.toList());
    }
    /*
    public static List<Product> ex3Products (List<Sale> salesNY){
        return salesNY.stream().map(sale -> sale.getItems().)
    }
*/







}
