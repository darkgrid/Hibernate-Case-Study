package com.jsp.case_study_one.service;

import java.util.Scanner;

import com.jsp.case_study_one.dao.ProductDao;
import com.jsp.case_study_one.entity.Product;

public class ProductService {

	ProductDao productDao = new ProductDao();
	Scanner input = new Scanner(System.in);

	public void addProduct() {
		System.out.print("Enter product name:");
		String name = input.next();

		System.out.print("Enter product price:");
		double price = input.nextDouble();

		System.out.println("Enter product quantity:");
		int quantity = input.nextInt();

		Product product = new Product();
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);

		String message = productDao.addProduct(product);

		System.out.println(message);
	}

	public void updateProduct() {
		System.out.println("Enter the product Id to update:");
		int id = input.nextInt();

		Product product = productDao.getProductById(id);
		if (product != null) {
			System.out.println(
					product.getProductName() + ", " + product.getProductPrice() + ", " + product.getProductQuantity());

			System.out.print("Enter product name:");
			String name = input.next();
			
			System.out.print("Enter product price:");
			double price = input.nextDouble();
			
			System.out.println("Enter product quantity:");
			int quantity = input.nextInt();
			
			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductQuantity(quantity);
			
			productDao.updateProduct(product);
		} else
			System.err.println("Product not found with the given Id!!");
	}

}
