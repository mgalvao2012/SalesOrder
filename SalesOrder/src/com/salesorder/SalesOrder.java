package com.salesorder;

import com.controller.*;


public class SalesOrder {
	
	// Create new Sales Order into the Database
    public String pushOrder(String W_ID, String Description, String Approver){      
    	System.out.println("W_ID: " + W_ID);
    	System.out.println("Description: " + Description);
    	System.out.println("Approver: " + Approver);
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();    	   	  	
        return SOPersistence.pushOrder(W_ID, Description, Approver);
    }

    // Check the status and justification of approval or rejection action
    public String checkOrder(String W_ID){
    	System.out.println("W_ID: " + W_ID);   	
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();
    	return SOPersistence.checkOrder(W_ID);
    }

    // Update the status and the justification of the Sales Order
    public String updateOrder(String W_ID, String Status, String Justify){      
    	System.out.println("W_ID: " + W_ID);
    	System.out.println("Status: " + Status);
    	System.out.println("Justify: " + Justify);
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();    	   	  	
        return SOPersistence.updateOrder(W_ID, Status, Justify);
    }

    // List all Sales Order for approval filtered by approver
    public String listOrder(String Approver){      
    	System.out.println("Approver: " + Approver);
    	SalesOrderPersistence SOPersistence = new SalesOrderPersistence();    	   	  	
        return SOPersistence.listOrder(Approver);
    }

}
