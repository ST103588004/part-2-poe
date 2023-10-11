/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory.management;
import java.util.Scanner;
/**
 *
 * @author david
 */

class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, int quantity, String expirationDate) {
        super(name, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
