import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a function:");
            System.out.println("1. Enter new product information");
            System.out.println("2. Print product list");
            System.out.println("3. Delete product by code");
            System.out.println("4. Sort products by descending price");
            System.out.println("5. Search for products by code or name");
            System.out.println("6. Search for products with price >= x");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    System.out.println("Enter the product code to delete:");
                    String code = scanner.nextLine();
                    removeByCode(code);
                    break;
                case 4:
                    sortByPriceDesc();
                    break;
                case 5:
                    System.out.println("Enter the product code or name to search:");
                    String keyword = scanner.nextLine();
                    Product product = findByCodeOrName(keyword);
                    if (product != null) {
                        System.out.println(product.toString());
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 6:
                    System.out.println("Enter the price x:");
                    float x = scanner.nextFloat();
                    List<Product> filteredProducts = filterByPrice(x);
                    if (!filteredProducts.isEmpty()) {
                        for (Product p : filteredProducts) {
                            System.out.println(p.toString());
                        }
                    } else {
                        System.out.println("No products found with price >= " + x);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product information:");
        System.out.println("Enter product code:");
        String code = scanner.nextLine();
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        System.out.println("Enter product price:");
        float price = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        Product product = new Product(name, description, code, price);
        productList.add(product);
    }

    public static void output() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public static void removeByCode(String code) {
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getCode().equals(code)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            productList.remove(productToRemove);
            System.out.println("Product with code " + code + " has been deleted");
        } else {
            System.out.println("No product found with code " + code);
        }
    }

    public static void sortByPriceDesc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Float.compare(p2.getPrice(), p1.getPrice());
            }
        });
        System.out.println("Products sorted by descending price.");
    }

    public static Product findByCodeOrName(String keyword) {
        for (Product product : productList) {
            if (product.getCode().equalsIgnoreCase(keyword) || product.getName().equalsIgnoreCase(keyword)) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> filterByPrice(float x) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.getPrice() >= x) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
