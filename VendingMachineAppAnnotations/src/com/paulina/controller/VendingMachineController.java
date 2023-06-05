package com.paulina.controller;

import com.paulina.userinterface.*;
import com.paulina.dao.*;
import com.paulina.businesslogic.*;
import com.paulina.pojo.Item;
import com.paulina.pojo.Coin;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.math.BigDecimal;

public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineService service;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws Exception {
    	while (true) {
            try {
            	
            	 BigDecimal amount = view.getUserFunds();
                 service.addFunds(amount);
                 
                view.displayMenu(service.getItems());
                int userSelection = view.getUserSelection();
                if (userSelection == 9) {
                	System.out.println("Have a nice day!");
                    break;
                    
                }

               

                service.vendItem(userSelection);

                Map<Coin, Integer> change = service.calculateChange();
                view.displayChange(change);
            } catch (Exception e) {
                view.displayErrorMessage(e.getMessage());
            }
        }

        service.writeInventory();
    }

	
}
