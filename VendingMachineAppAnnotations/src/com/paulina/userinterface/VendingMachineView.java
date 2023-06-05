package com.paulina.userinterface;

import com.paulina.pojo.Coin;
import com.paulina.pojo.Item;

import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;

public class VendingMachineView {

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu(Map<Integer, Item> items) {
        System.out.println("All products in Vending Machine!\n");

        for (Item item : items.values()) {
        	
            System.out.println(item.getNumber()+"."+item.getName() + " - $" + item.getCost() + " - " + item.getInventory() + " in stock");
        }

        System.out.println("\nEnter '9' to quit the program.\n");
    }

    public int getUserSelection() {
        System.out.print("Please select an item: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public BigDecimal getUserFunds() {
        while (true) {
            try {
                System.out.print("Welcome to the Vending Machine! \nPlease enter the amount of money you want to put in: ");
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public void displayChange(Map<Coin, Integer> change) {
        System.out.println("\nYour change is: ");
        for (Map.Entry<Coin, Integer> entry : change.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

  public void displayErrorMessage(String errorMessage) {
      System.out.println("Error: " + errorMessage);
   }
}
