package com.paulina.businesslogic;

import java.math.BigDecimal;

import java.util.Map;
import java.util.HashMap;

import com.paulina.dao.AuditDao;
import com.paulina.dao.ItemDao;
import com.paulina.exeptions.*;
import com.paulina.pojo.Item;
import com.paulina.pojo.Coin;

public class VendingMachineService {
	
	
	
	private ItemDao itemDao;
    private AuditDao auditDao;
    private BigDecimal funds;
    
    
    //constructor
    //getters
    //setters
    
    public VendingMachineService(ItemDao itemDao, AuditDao auditDao, BigDecimal funds) {
		super();
		this.itemDao = itemDao;
		this.auditDao = auditDao;
		this.funds = funds;
	}
	
    
	public ItemDao getItemDao() {
		return itemDao;
	}


	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}


	public AuditDao getAuditDao() {
		return auditDao;
	}


	public void setAuditDao(AuditDao auditDao) {
		this.auditDao = auditDao;
	}


	public BigDecimal getFunds() {
		return funds;
	}


	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}
 
    
    //method to add funds
	public void addFunds(BigDecimal amount) {
        this.funds = this.funds.add(amount);
    }
	
    //method to vend item
	public void vendItem(int number) throws Exception {
	    Item item = itemDao.getItem(number);
	    
	    if (item == null) {
	        throw new ItemNotFoundException("This item does not exist.");
	    }

	    if (item.getInventory() <= 0) {
	        throw new NoItemInventoryException("This item is out of stock.");
	    }

	    if (item.getCost().compareTo(funds) >= 0) {
	       System.out.println("You don't have enough money to buy this item.");
	    }

	    funds = funds.subtract(item.getCost());
	    itemDao.reduceItemInventory(number);
	    auditDao.writeLogEntry("Item " + number +" vended."); // Log the vending event
	}
	
    //method to calculate change
	
	public Map<Coin, Integer> calculateChange() {
	   
		Map<Coin, Integer> change = new HashMap<>();
	    int remainingFundsInPennies = funds.multiply(new BigDecimal(100)).intValueExact();
	    
	    for (Coin coin : Coin.values()) {
	        int count = remainingFundsInPennies / coin.getPennies();
	        remainingFundsInPennies -= count * coin.getPennies();
	        change.put(coin, count);
	    }

	    funds = BigDecimal.ZERO;  
	    return change;
	}

	public Map<Integer, Item> getItems() {
        return itemDao.getItems();
    }


	public void writeInventory() throws Exception {
	    try {
	        itemDao.writeInventory();
	    } catch (IOException e) {
	        System.err.println("Could not write inventory to file. Error: " + e.getMessage());
	        throw e; 
	    }
	}


}

