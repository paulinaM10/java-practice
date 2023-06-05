package com.paulina.pojo;

import java.math.BigDecimal;

public class Item {
	
	//properties of the item in vending machine 
	private int number;
	private String name;
	private BigDecimal cost;
	private int inventory;
	
	
	public Item(int number, String name, BigDecimal cost, int inventory) {
		super();
		this.number=number;
		this.name = name;
		this.cost = cost;
		this.inventory = inventory;
	}


	public String getName() {
		return name;
	}



	public BigDecimal getCost() {
		return cost;
	}


	public int getInventory() {
		return inventory;
	}


	public void setInventory(int inventory) {
		this.inventory = inventory;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	

	

}
