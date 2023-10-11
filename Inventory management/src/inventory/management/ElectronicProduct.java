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

class ElectronicProduct extends Product {
    private String brand;

    public ElectronicProduct(String name, int quantity, String brand) {
        super(name, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
