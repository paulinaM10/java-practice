package com.paulina.dao;

import java.util.*;
import java.math.BigDecimal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.paulina.pojo.Item;

public class ItemDaoImpl implements ItemDao {
	
	private Map<Integer, Item> items = new HashMap<>();
	
	public ItemDaoImpl() throws Exception {
	    try {
	        loadInventory();
	    } catch (FileNotFoundException e) {
	        System.err.println("Could not load inventory. Error: " + e.getMessage());
	    }
	}

	@Override
	public void loadInventory() throws Exception {
		
		Scanner scanner = new Scanner(new FileReader("./src/inventory.txt"));

        while (scanner.hasNextLine()) {
            String[] itemDetails = scanner.nextLine().split(",");
            int number = Integer.parseInt(itemDetails[0]);
            String name = itemDetails[1];
            BigDecimal cost = new BigDecimal(itemDetails[2]);
            int inventory = Integer.parseInt(itemDetails[3]);

            Item item = new Item(number, name, cost, inventory);
            items.put( number, item);
            
        }
    }
	

	@Override
	public void writeInventory() throws Exception {
		
		FileWriter fileWriter = new FileWriter("./src/inventory.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Item item : items.values()) {
            printWriter.println(item.getName() + "," + item.getCost() + "," + item.getInventory());
        }
        
        printWriter.flush();
        printWriter.close();
	}

	@Override
	public void reduceItemInventory(int number) {
        Item item = items.get(number);
        if (item != null) {
            item.setInventory(item.getInventory() - 1);
        }
    }

    @Override
    public Map<Integer, Item> getItems() {
        return items;
    }


	@Override
	public Item getItem(int number) {
		return items.get(number);
	}


	
}
