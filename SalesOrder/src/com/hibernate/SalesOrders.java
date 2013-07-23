package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 create table sales_orders (W_ID char(6) not null primary key,Description char(50),Approver char(12),Status char(1),Justify char(50))
 */

@Entity
@Table(name = "Sales_Orders")
public class SalesOrders {

	@Id
	private String W_ID;
	private String Description;
	private String Approver;
	private String Status;
	private String Justify;

	public String getW_ID() {
		return W_ID;
	}

	public void setW_ID(String w_ID) {
		W_ID = w_ID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getApprover() {
		return Approver;
	}

	public void setApprover(String approver) {
		Approver = approver;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getJustify() {
		return Justify;
	}

	public void setJustify(String justify) {
		Justify = justify;
	}

}
