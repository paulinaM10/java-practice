package com.paulina.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paulina.businesslogic.VendingMachineService;
import com.paulina.controller.VendingMachineController;
import com.paulina.dao.AuditDaoImpl;
import com.paulina.dao.ItemDaoImpl;
import com.paulina.userinterface.VendingMachineView;

public class App {

    public static void main(String[] args) throws Exception {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.register(AppConfig.class);
    	context.refresh();

    	 VendingMachineView view = context.getBean("vendingMachineView", VendingMachineView.class);
         ItemDaoImpl itemDao = context.getBean("itemDao", ItemDaoImpl.class);
         AuditDaoImpl auditDao = context.getBean("auditDao", AuditDaoImpl.class);
         VendingMachineService service = context.getBean("vendingMachineService", VendingMachineService.class);

         VendingMachineController controller = new VendingMachineController(view, service);

         controller.run();
    }
}
