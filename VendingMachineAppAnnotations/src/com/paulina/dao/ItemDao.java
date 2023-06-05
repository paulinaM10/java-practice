package com.paulina.dao;

import java.util.Map;

import com.paulina.exeptions.FileNotFoundException;
import com.paulina.exeptions.IOException;
import com.paulina.pojo.Item;

public interface ItemDao {
	
	
	void loadInventory() throws  Exception;
    void writeInventory() throws Exception;
    Item getItem(int name);
    void reduceItemInventory(int number);
	Map<Integer, Item> getItems();
	
	

}


