package quickFoods;

import java.util.Scanner;

public class Customer {
	//Customer Attributes
	static String orderNumber;
	static String userName;
	String userPhone;
	static String userAddress;
	String userEmail;
	static String userCity;
	
	//Customer Constructor
	public Customer(String userCity, String orderNumber, String userName, String userPhone, String userAddress, String userEmail) {
		Customer.userCity = userCity;
		Customer.orderNumber = orderNumber;
		Customer.userName = userName;
		this.userPhone = userPhone;
		Customer.userAddress = userAddress;
		this.userEmail = userEmail;
	}
	
	//method to get userName
	public static String getUserName() {
		return userName;
	}
	
	//method to get Customer City
	public static String getCustomerCity() {
		return userCity;
	}
	
	//method to get Customer's Address
	public static String getCustomerAddress() {
		return userAddress;
	}
	
	//Method to Create Customer
	public static Customer displayCustomer() {
		//Order Number
		int min = 1000;
		int max = 9999;
		String orderNumber = Integer.toString((int) (Math.random() * (max - min + 1) + min));
		//Customer City
		System.out.println("What city are you in?");
		Scanner input = new Scanner(System.in);
		String userCity= input.nextLine();
		
		//Customer Name
		System.out.println("Please enter your full name:");
		String userName = input.nextLine();
			
		//Customer Phone Number
		System.out.println("Please enter your phone number:");
		String userPhone = input.nextLine();
			
		//Customer Address
		System.out.println("Please enter your street address:");
		String userAddress = input.nextLine();
			
		// Customer Email
		System.out.println("Please enter your email address:");
		String userEmail = input.nextLine();
		
		//Create newCustomer and return new Customer Object
		Customer newCustomer = new Customer(userCity, orderNumber, userName, userPhone, userAddress, userEmail);
		
		return newCustomer;
		
	}
	
	//Method to Display Customer Details
	public String customerDetails() {
		String details = "Order number " + Customer.orderNumber + "\n" +
				"Customer: " + Customer.userName + "\n" +
				"Email: " + this.userEmail + "\n" +
				"Phone number: " + this.userPhone + "\n" +
				"Location: " + Customer.userCity + "\n";
		
		return details;
	}
	
}
