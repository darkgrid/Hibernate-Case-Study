package com.jsp.case_study_one;

import java.util.Scanner;

import com.jsp.case_study_one.service.ProductService;

public class App {
	
	public static void main(String[] args) {
		System.out.println("Enter:\n"
				+ "1 to addProduct\n"
				+ "2 to get Product by Id\n"
				+ "3 to get all products\n"
				+ "4 to update product\n"
				+ "5 to delete product\n"
				+ "0 to terminate\n");
		
		Scanner input = new Scanner(System.in);
		
		int choice = input.nextInt();
		
		ProductService productService = new ProductService();
		switch (choice) {
		case 1:
			productService.addProduct();
			break;
		case 4:
			productService.updateProduct();
			break;
		case 0:
			System.err.println("Program Terminated!!");
			break;
		default:
			System.err.println("Invalid Input!!");
			break;
		}
	}

}
