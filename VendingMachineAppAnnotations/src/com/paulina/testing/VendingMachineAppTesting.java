package com.paulina.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.paulina.businesslogic.VendingMachineService;
import com.paulina.dao.AuditDao;
import com.paulina.dao.ItemDao;
import com.paulina.pojo.Item;

import java.math.BigDecimal;

class VendingMachineAppTesting {
	
	private VendingMachineService service;
    private ItemDao itemDao;
    private AuditDao auditDao;

	@BeforeEach
	void setUp() throws Exception {
        service = new VendingMachineService(itemDao, auditDao, new BigDecimal("0.00"));
    
	}

	@AfterEach
	void tearDown() throws Exception {
		itemDao = null;
        auditDao = null;
        service = null;
	}

//	@Test
//	void testVendingMachineService() {
//		fail("Not yet implemented");
//	}
//
	@Test
    void testSetAndGetItemDao() {
        ItemDao newItemDao = service.getItemDao();
        service.setItemDao(newItemDao);
        assertEquals(newItemDao, service.getItemDao());
    }

    @Test
    void testSetAndGetAuditDao() {
        AuditDao newAuditDao = service.getAuditDao();
        
        service.setAuditDao(newAuditDao);
        assertEquals(newAuditDao, service.getAuditDao());
    }
//@Test
    void testSetAndGetFunds() {
        service.setFunds(new BigDecimal("5.00"));
        assertEquals(new BigDecimal("5.00"), service.getFunds());
    }
	@Test
	void testAddFunds() {
		service.addFunds(new BigDecimal("1.00"));
        assertEquals(new BigDecimal("1.00"), service.getFunds());
    	}

//	@Test
//    void testVendItem() throws Exception {
//        
//    }

//	@Test
//	void testCalculateChange() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetItems() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWriteInventory() {
//		fail("Not yet implemented");
//	}

}
