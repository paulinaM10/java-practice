package com.paulina.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

import com.paulina.businesslogic.VendingMachineService;
import com.paulina.controller.VendingMachineController;
import com.paulina.dao.AuditDao;
import com.paulina.dao.AuditDaoImpl;
import com.paulina.dao.ItemDao;
import com.paulina.dao.ItemDaoImpl;
import com.paulina.userinterface.VendingMachineView;

@Configuration
public class AppConfig {
    
    @Bean
    public VendingMachineController vendingMachineController() throws Exception {
        return new VendingMachineController(vendingMachineView(), vendingMachineService());
    }
    
    @Bean
    public VendingMachineView vendingMachineView() {
        return new VendingMachineView();
    }
    
    @Bean
    public VendingMachineService vendingMachineService() throws Exception {
        return new VendingMachineService(itemDao(), auditDao(), new BigDecimal("0.00"));
    }
    
    @Bean
    public ItemDao itemDao() throws Exception {
        return new ItemDaoImpl();
    }
    
    @Bean
    public AuditDao auditDao() {
        return new AuditDaoImpl();
    }
}
