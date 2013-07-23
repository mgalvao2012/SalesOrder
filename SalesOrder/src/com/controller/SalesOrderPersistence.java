package com.controller;

import com.hibernate.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class SalesOrderPersistence {

	public String pushOrder(String W_ID, String Description, String Approver) {

		String retorno = "OK";
		SalesOrders SalesOrdersTable = new SalesOrders();
		SalesOrdersTable.setW_ID(W_ID);
		SalesOrdersTable.setDescription(Description);
		SalesOrdersTable.setApprover(Approver);
		SalesOrdersTable.setStatus("0"); // 0-waiting 1-approved 2-rejected

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(SalesOrdersTable);
			tx.commit();
			tx = null;
		} catch (Exception e) {
			retorno = e.getMessage();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return retorno;
	}

	public String checkOrder(String W_ID) {

		String retorno;
		String status = "";
		String justify = "";
		SalesOrders SalesOrdersTables;

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			SalesOrdersTables = (SalesOrders) session.get(SalesOrders.class,
					W_ID);
			status = SalesOrdersTables.getStatus();
			justify = SalesOrdersTables.getJustify();
		} catch (Exception e) {
			retorno = e.getMessage();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			tx = null;
		}

		retorno = "<STATUS>" + status + "</STATUS><JUSTIFIY>" + justify
				+ "</JUSTIFY>";

		return retorno;
	}

	public String updateOrder(String W_ID, String Status, String Justify) {

		String retorno = "OK";
		SalesOrders SalesOrdersTable;

		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			SalesOrdersTable = (SalesOrders) session.get(SalesOrders.class,
					W_ID);
			SalesOrdersTable.setStatus(Status);
			SalesOrdersTable.setJustify(Justify);
			session.update(SalesOrdersTable);
			tx.commit();
			tx = null;
		} catch (Exception e) {
			retorno = e.getMessage();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			tx = null;
		}

		return retorno;
	}

	public String listOrder(String Approver) {

		String retorno = "";
		String query = "";
		SessionFactory sessionFactory = new AnnotationConfiguration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			query = "from SalesOrders where Approver = :Approver and Status = '0'";
			Query q = session.createQuery(query);
			q.setString("Approver", Approver);
			java.util.Iterator iter = q.iterate();
			retorno = "<SALES_ORDERS>";
			while (iter.hasNext()) {
				SalesOrders order = (SalesOrders) iter.next(); // fetch the
																// object
				retorno += "<SALESORDER>";
				retorno += "<W_ID>" + order.getW_ID() + "</W_ID>";
				retorno += "<DESCRIPTION>" + order.getDescription()
						+ "</Description>";
				retorno += "<STATUS>" + order.getStatus() + "</STATUS>";
				retorno += "</SALESORDER>";
			}
			retorno += "</SALES_ORDERS>";
			tx.commit();
			tx = null;
		} catch (Exception e) {
			retorno = e.getMessage();
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			tx = null;
		}
		return retorno;
	}

}
