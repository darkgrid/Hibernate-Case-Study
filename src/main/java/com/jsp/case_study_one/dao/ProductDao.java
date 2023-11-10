package com.jsp.case_study_one.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.case_study_one.entity.Product;

public class ProductDao {
	
	Configuration cgf = new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory factory = cgf.buildSessionFactory();
	
	public String addProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		
		return "product successfully saved!!";
	}
	
	public Product getProductById(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, id);
		transaction.commit();
		session.close();
		
		return product;
	}
	
	public List<Product> getAllProducts(){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("From Product");
		List<Product> products = query.getResultList();
		transaction.commit();
		session.close();
		
		return products;
	}
	
	public String updateProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
		
		return "product successfully updated!!";
	}
	
	public String deleteProduct(Product product) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();
		
		return "product successfully delted!!";
	}

}
