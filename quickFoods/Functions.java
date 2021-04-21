package quickFoods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Functions {
	//instantiate variables
	
	// new Customer, city, userCity, customer location, and instantiate driver for order
	static Customer newCustomer = Customer.displayCustomer();
	static Restaurant newOrder = Restaurant.displayOrder();
	static String customerCity = Customer.getCustomerCity();
	static String customerLocation = Customer.getCustomerAddress();
	static Driver driverForOrder = null;
	
	//declare driver, driverName, scanner
	static String driver = null;
	static String driverName = null;
	static Scanner input;
	
	//Create Empty array list to be add the available drivers in customer city locations
	static ArrayList<String> customerDriver = new ArrayList<>();
	
	//Create a HashSet of city locations drivers are in
    static HashSet<String> cities = new HashSet<String>();
    
    //method to add cities into HashSet
    public static void addCities(HashSet<String> cities) {
    	cities.add("Cape Town");
        cities.add("Durban");
        cities.add("Johannesburg");
        cities.add("Potchefstroom");
        cities.add("Springbok");
        cities.add("Bloemfontein");
        cities.add("Port Elizabeth");
        cities.add("Witbank");
		
    }
	
	//method to create customer's invoice
    public static void createInvoice() {
    	//declare a file and PrintWriter
    	File invoice;
    	PrintWriter writer;
    	//add cities to HashSet
    	addCities(cities);
    	
    	//if the driver locations match the customer city
    	if(cities.contains(customerCity)) {
    		//try catch to read the driver text file and create invoice file
    		try {
    			File driverText = new File("drivers-info.txt");
    			input = new Scanner(driverText);
    			
    			//while there are more drivers into array 
    			while(input.hasNextLine()) {
    				
    				String fileInfo = input.nextLine();
    				String [] driverArray = fileInfo.split(", ");
    				String customerAddress = customerCity;
    				String [] custAddressArray = customerAddress.split(", ");
    				
    				//compare customer city to city in driver array
    				if(custAddressArray[0].equals(driverArray[1])) {
    					//if match add driver to list
    					customerDriver.add(fileInfo);
    				}
    			}
    			
    			//create variable for lowest number
    			int lowestNum = 1000;
    			
    			// for the size of the ArrayList of CustomerDrivers run loop
    			// to determine driver with least amount of deliveries
    			for(int i = 0; i < customerDriver.size(); i++) {
    				
    				String [] firstDriver = customerDriver.get(i).split(", ");
    				int firstDriverNum = Integer.parseInt(firstDriver[2]);
    				
    				//if the first driver in the loop is lower than lowestNum it becomes lowestNum and so on until lowest is found
    				if(lowestNum > firstDriverNum){
    					lowestNum = firstDriverNum;
    					//driver becomes the driver with the lowest number of orders
    					driver = customerDriver.get(i);
    				}
        		
    				String [] selectedDriverArray = driver.split(", ");
    				driverName = selectedDriverArray[0];
    				
    				//create a new driver
    				driverForOrder = new Driver(driverName, customerLocation);
    				input.close();
    			}
           
    		}
    		catch (FileNotFoundException e) {
    			System.out.println("Sorry, no file found");
    			e.printStackTrace();
    		}
    		
    		//try to create new text file invoice.txt and write customers order and details to that file
    		try {
    			invoice = new File("invoice.txt");
    			writer = new PrintWriter(invoice);
    			
    			writer.println(newCustomer.customerDetails());
    			writer.println(newOrder.restuarantDetails());
      			writer.println(Driver.displayDriver());
      			writer.println(newOrder.restaurantInfo());
    			
    			writer.close();
    		} 
    		catch(IOException e) {
    			e.printStackTrace();
    			System.out.println("Cannot find file");
    		}
    	
    	}
    	
    	//else the driver locations don't match the customer location create a new file invoice and print statement
    	else {
    		try {
    			invoice = new File("invoice.txt");
    			writer = new PrintWriter(invoice);
    			writer.println("“Sorry! Our drivers are too far away from you to be able to deliver to your location.”");
			
    			writer.close();
    		} 
    		catch(IOException e) {
    			e.printStackTrace();
    			System.out.println("Cannot find file");
    		}
    	}
    	
    }

    //method to create customer text file sorted in alphabetical order
    public static void customerTxt() {
    	
    	try {
    		//create new file. If the file exists append the file data
    		BufferedWriter customerOrderReader = new BufferedWriter (new FileWriter("customers.txt", true));
    		customerOrderReader.close();
    		
    		//create a new variable containing customer name and order number
    		String nextCustomer = "Customer Name: " + Customer.userName + "| Order Number: " + Customer.orderNumber;	
    		File customerInfo = new File("customers.txt");
    		Scanner customerListReader = new Scanner(customerInfo);
    		ArrayList<String> customerList = new ArrayList<>();
    		
    		//while there is a next line in the file add that to the ArrayList
    		while(customerListReader.hasNextLine()) {
    			customerList.add(customerListReader.nextLine());
    		}
    		
    		customerListReader.close();
    		//add the newest customer to ArrayList and sort, create a new array
    		customerList.add(nextCustomer);
    		Collections.sort(customerList);
    		String [] customerArray = new String[customerList.size()];
    		
    		//for the length of the array list add each customer in ArrayList to array
    		for(int i = 0; i < customerList.size(); i++) {
    			customerArray[i] = customerList.get(i);
    		}
    		
    		
    		BufferedWriter newCustomerList = new BufferedWriter(new FileWriter ("customers.txt"));
    		//for the length of the string array write the customer info over previous file
    		for (int j = 0; j < customerArray.length; j ++) {
    			newCustomerList.write(customerArray[j] + "\n");
    		}
    		
    		newCustomerList.close();
    	
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("Cannot find file");
    	}
    	
    }
	
    //method to create customer location text file
    public static void customerLocationTxt() {
    	
    	try {
    		//create new file. If the file exists append the file data
    		BufferedWriter customerLocationOrder = new BufferedWriter (new FileWriter("customersLocation.txt", true));
    		customerLocationOrder.close();
    		
    		//create new variable for city and customer name to be printed in file
    		String nextCustomer = Customer.userCity + " | Customer Name: " + Customer.userName;
    		
    		File customerLocationList = new File("customersLocation.txt");
    		Scanner customerLocationReader = new Scanner(customerLocationList);
    		ArrayList<String> customerList = new ArrayList<>();
    		
    		//while the file has a next line add data into the array list
    		while(customerLocationReader.hasNextLine()) {
    			customerList.add(customerLocationReader.nextLine());
    		}
    	
    		customerLocationReader.close();
    		//add the new city and customer name to array list, sort, and create new array
    		customerList.add(nextCustomer);
    		Collections.sort(customerList);
    		String [] customerLocationArray = new String [customerList.size()];
    		
    		//for the size of the array list add the data from the array list to the array
    		for(int i = 0; i < customerList.size(); i++) {
    			customerLocationArray[i] = customerList.get(i);
    		}
    		
    		BufferedWriter newCustomerLocationOrder = new BufferedWriter ( new FileWriter("customersLocation.txt"));
    		//for the length of the array update the data of the file using what is in the array
    		for (int j = 0; j < customerLocationArray.length; j ++) {
    			newCustomerLocationOrder.write(customerLocationArray[j] + "\n");
    		}
    	
    		newCustomerLocationOrder.close();
    		
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("Cannot find file");
    	}
    	
    }
    
    //method to update driver text file adding orders
    public static void updateDriver() {
    	
    	try {
    		//create new file. If the file exists append the file data
    		BufferedWriter driversText = new BufferedWriter (new FileWriter("drivers-info.txt", true));
    		driversText.close();
    	
    		//add 1 to the drivers orders that is taking the order on invoice
    		String [] chosenDriver = driver.split(", ");	
    		int driverOrder = Integer.parseInt(chosenDriver[2]);
    		driverOrder += 1;
    		String strDriverOrder = Integer.toString(driverOrder);
    		chosenDriver[2] = strDriverOrder;
    		String newChosenDriver = chosenDriver[0] + ", " + chosenDriver[1] + ", " + chosenDriver[2];
    		
    		ArrayList<String> driverArrayList = new ArrayList<>();
    		File driverTextToRead = new File("drivers-info.txt");
    		Scanner driverTextReader = new Scanner(driverTextToRead);
    		
    		//while the file has a next line add the line into ArrayList
    		while(driverTextReader.hasNextLine()) {
    			driverArrayList.add(driverTextReader.nextLine());
    		}
   
    		driverTextReader.close();
    		
    		//if the driver ArrayList contains the driver, remove the driver
    		if(driverArrayList.contains(driver)) {
    			driverArrayList.remove(driver);
    		}
    		
    		//add the driver back in the array list with the added order number, sort, create new array
    		driverArrayList.add(newChosenDriver);
    		Collections.sort(driverArrayList);;
    		String [] newDriverArray = new String [driverArrayList.size()];
    		
    		//for the size of the array list add the items from the ArrayList into the array
    		for(int i= 0; i < driverArrayList.size(); i ++) {
    			newDriverArray[i] = driverArrayList.get(i);
    		}
    		
    		BufferedWriter newDrivers = new BufferedWriter ( new FileWriter("drivers-info.txt"));
    		
    		//for the length of the array write the items of the array into the file
    		for(int j = 0; j < newDriverArray.length; j++) {
    			newDrivers.write(newDriverArray[j] + "\n");
    		}
    		
    		newDrivers.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("Cannot find file");
    	}
    	
    }
    
}
