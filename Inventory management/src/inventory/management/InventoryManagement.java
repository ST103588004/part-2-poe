package inventory.management;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManagement { 
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
//promts
    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Electronic Product");
            System.out.println("2. Add Food Product");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Check Product Stock");
            System.out.println("5. Generate Inventory Report");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
//switch case for choices
            switch (choice) {
                case 1:
                    addElectronicProduct();
                    break;
                case 2:
                    addFoodProduct();
                    break;
                case 3:
                    updateProductQuantity();
                    break;
                case 4:
                    checkProductStock();
                    break;
                case 5:
                    generateInventoryReport();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//add feature
    private static void addElectronicProduct() {
        System.out.print("Enter the electronic product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the initial quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the brand: ");
        String brand = scanner.nextLine();

        ElectronicProduct product = new ElectronicProduct(name, quantity, brand);
        products.add(product);

        System.out.println("Electronic product added successfully.");
    }
//add foodproduct feature
    private static void addFoodProduct() {
        System.out.print("Enter the food product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the initial quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the expiration date: ");
        String expirationDate = scanner.nextLine();

        FoodProduct product = new FoodProduct(name, quantity, expirationDate);
        products.add(product);

        System.out.println("Food product added successfully.");
    }
// updating feature
    private static void updateProductQuantity() {
        System.out.print("Enter the product name to update quantity: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchName)) {
                System.out.print("Enter the new quantity: ");
                int newQuantity = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                product.updateQuantity(newQuantity);
                System.out.println("Quantity updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
//check product feature
    private static void checkProductStock() {
        System.out.print("Enter the product name to check stock: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Stock of " + searchName + ": " + product.getQuantity() + " units");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
// inventory report for stock feature
    private static void generateInventoryReport() {
        System.out.println("Inventory Report:");
        for (Product product : products) {
            if (product instanceof ElectronicProduct) {
                ElectronicProduct electronicProduct = (ElectronicProduct) product;
                System.out.println("Electronic Product: " + electronicProduct.getName() +
                                   ", Brand: " + electronicProduct.getBrand() +
                                   ", Quantity: " + electronicProduct.getQuantity() + " units");
            } else if (product instanceof FoodProduct) {
                FoodProduct foodProduct = (FoodProduct) product;
                System.out.println("Food Product: " + foodProduct.getName() +
                                   ", Expiration Date: " + foodProduct.getExpirationDate() +
                                   ", Quantity: " + foodProduct.getQuantity() + " units");
            }
        }
    }
}