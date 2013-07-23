package com.salesorder;

import com.controller.*;


public class SalesOrder {
	
    public String pushOrder(String W_ID, String Description, String Approver){      
    	System.out.println("W_ID: " + W_ID);
    	System.out.println("Description: " + Description);
    	System.out.println("Approver: " + Approver);
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();    	   	  	
        return SOPersistence.pushOrder(W_ID, Description, Approver);
    }

    public String checkOrder(String W_ID){
    	System.out.println("W_ID: " + W_ID);   	
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();
    	return SOPersistence.checkOrder(W_ID);
    }

    public String updateOrder(String W_ID, String Status, String Justify){      
    	System.out.println("W_ID: " + W_ID);
    	System.out.println("Status: " + Status);
    	System.out.println("Justify: " + Justify);
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();    	   	  	
        return SOPersistence.updateOrder(W_ID, Status, Justify);
    }

    
    public String listOrder(String Approver){      
    	System.out.println("Approver: " + Approver);
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();    	   	  	
        return SOPersistence.listOrder(Approver);
    }

}
