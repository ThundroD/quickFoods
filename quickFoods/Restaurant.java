package quickFoods;

import java.util.Scanner;
// create class
public class Restaurant {
	//Restaurant Only Attributes
	static String foodName;
	String foodPhone;
	String foodItem1;
	String foodItem2;
	String foodItem3;
	String foodQuanity1;
	String foodQuanity2;
	String foodQuanity3;
	String foodPrice;
	String foodInstructions;
	String foodTotal;
	String userCity;
//Restaurant Constructor
	public Restaurant(String userCity, String foodName, String foodPhone, String foodItem1, String foodItem2, String foodItem3, String foodQuanity1, String foodQuanity2,
		String foodQuanity3, String foodPrice, String foodInstructions, String foodTotal) {
	
	Restaurant.foodName = foodName;
	this.foodPhone = foodPhone;
	this.foodItem1 = foodItem1;
	this.foodItem2 = foodItem2;
	this.foodItem3 = foodItem3;
	this.foodQuanity1 = foodQuanity1;
	this.foodQuanity2 = foodQuanity2;
	this.foodQuanity3 = foodQuanity3;
	this.foodPrice = foodPrice;
	this.foodInstructions = foodInstructions;
	this.foodTotal = foodTotal;
	this.userCity = userCity;
	
	}


	//Restaurant Display Method
	public static Restaurant displayOrder() {
			//Restaurant Name
			String foodName = getRestaurantName();
			
			//find foodPhone
			String foodPhone = "";
			if("Aesop’s Pizza".equals(foodName)) {
				foodPhone = "082 355 6441";
			}
			else if("Hurry My Curry".equals(foodName)) {
				foodPhone = "079 551 4572";
			}
			else if("Kong Pow Kusine".equals(foodName)) {
				foodPhone = "079 551 4572";
			}
			
			Scanner input = new Scanner(System.in);
		
			//Menus Variables
			//create a double for food price to do calculations with
			double foodPriceDouble = 0.00;
			//make empty strings for food items to be added if selected
			String foodItem1 = "";
			String foodItem2 = "";
			String foodItem3 = "";
			
			//create a foodPrice Sting to be displayed later
			String foodPrice = "";
			//Create a food price string to be added to later
			String foodTotal= null;
			
			//create counters to count how many items of each menu is added
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			
			//Create food quantity strings which will display the counted items later on
			String foodQuanity1 = null;
			String foodQuanity2 = null;
			String foodQuanity3 = null;
			
			//if Aesop is selected- Display Aesop Menu
			if("Aesop’s Pizza".equals(foodName)) {
				
				//Prices for Pizza
				double pepPizzaPrice = 78.99;
				double hawPizzaPrice = 82.99;
				double shoomPizzaPrice = 55.99;
			
				//create item number to be the input and the ordering for the do/while loop to be true
				String itemNumber;
				boolean ordering = true;
				
				//display menu while user does not select 4
				do {
					System.out.println("Aesop's Pizza Menu \n \n" +
							"Please enter the number of the menu item you'd like to order OR enter '4' if you don't want anything else \n"
							+ "1. Pepperoni pizza (R78.99) \n"
							+ "2. Hawaiian pizza (R82.99) \n"
							+ "3. Shroom Pizza (R55.99) \n"
							+ "4. I don't want anything else"
							);
					
					itemNumber = input.nextLine();
					
					//if an item is selected counter adds 1 and foodItem becomes that item
					if("1".equals(itemNumber)) {
						foodItem1 = "x Pepperoni pizza (R78.9) \n";
						count1++;
						ordering = true;	
					}
					else if("2".equals(itemNumber)) {
						foodItem2 = "x Hawaiian pizza (R82.99) \n";
						count2++;
						ordering = true;
					}
					else if("3".equals(itemNumber)) {
						foodItem3 = "x Shroom Pizza (R55.99) \n";
						count3++;
						ordering = true;
					}
					else if("4".equals(itemNumber)) {
						ordering = false;
						
					}
					else {
						System.out.println("Please enter a correct item number");
						ordering = true;
					}
				}while(ordering == true);
			
					
				//Calculate Total
				foodPriceDouble = (double)Math.round(100 * ((pepPizzaPrice * count1) + (hawPizzaPrice * count2) + (shoomPizzaPrice * count3))) / 100;
				foodTotal = String.valueOf(foodPriceDouble);
				
				//if a count == 0 then foodQuanity becomes empty string
				if (count1 == 0) {
					foodQuanity1 = "";
				}
				else {
					foodQuanity1 = String.valueOf(count1);
				}
				
				if (count2 == 0) {
					foodQuanity2 = "";
				}
				else {
					foodQuanity2 = String.valueOf(count2);
				}
				
				if (count3 == 0) {
					foodQuanity3 = "";
				}
				else {
					foodQuanity3 = String.valueOf(count3);
				}
		
			}
			//if Kong Pow is selected display Kong Pow menu
			else if("Kong Pow Kusine".equals(foodName)) {
				
				//Kong Pow Food Price
				double tsoChicken = 78.99;
				double padThai = 82.99;
				double kongPow = 55.99;
				//input number for order
				String kongNumber;
				//ordering for do while set for true
				boolean ordering = true;
				
				//display do menu until user selects 4
				do {
				
					System.out.println("Kong Pow Kusine Menu \n \n" +
							"Please enter the number of the menu item you'd like to order OR enter '4' if you don't want anything else \n"
							+ "1. General Tso's Chicken (R78.99) \n"
							+ "2. Pad Thai (R82.99) \n"
							+ "3. Kong Pow Rice (R55.99) \n"
							+ "4. I don't want anything else"
							);
					kongNumber = input.nextLine();
						if("1".equals(kongNumber)) {
							foodItem1 = "x General Tso's Chicken (R78.99) \n";
							count1++;
							ordering = true;
						}
						else if("2".equals(kongNumber)) {
							foodItem2 = "x Pad Thai (R82.99) \n";
							count2++;
							ordering = true;
						}
						else if("3".equals(kongNumber)) {
							foodItem3 = "x Kong Pow Rice (R55.99) \n";
							count3++;
							ordering = true;
						}
						else if("4".equals(kongNumber)) {
							ordering = false;
						}
						else {
							System.out.println("Please enter a correct item number");
							ordering = true;
						}
				}while(ordering == true);
			
				//Get food Total
				foodPriceDouble = (double)Math.round(100 * ((tsoChicken * count1) + (padThai * count2) + (kongPow * count3))) / 100;
				foodTotal = String.valueOf(foodPriceDouble);
				
				//if a counter is 0 then make foodQuantity and empty string
				if (count1 == 0) {
					foodQuanity1 = "";
				}
				else {
					foodQuanity1 = String.valueOf(count1);
				}
				
				if (count2 == 0) {
					foodQuanity2 = "";
				}
				else {
					foodQuanity2 = String.valueOf(count2);
				}
				
				if (count3 == 0) {
					foodQuanity3 = "";
				}
				else {
					foodQuanity3 = String.valueOf(count3);
				}
				
			}
			//if Hurry My Curry is selected display menu
			else if("Hurry My Curry".equals(foodName)) {
				//menu price items
				double butterChicken = 78.99;
				double tikkaMasala = 82.99;
				double bunnyChow = 55.99;
				//order intake is declared and ordering is set for true for do while loop
				String curryNumber;
				boolean ordering = true;
				
				//menu is printed as long as user doesn't select 4
				do {
					System.out.println("Kong Pow Kusine Menu \n \n" +
							"Please enter the number of the menu item you'd like to order OR enter '4' if you don't want anything else \n"
							+ "1. Butter Chicken (R78.99) \n"
							+ "2. Chicken Tikka Masala (R82.99) \n"
							+ "3. Bunny Chow (R55.99) \n"
							+ "4. I don't want anything else"
					);
					curryNumber = input.nextLine();
				
					if("1".equals(curryNumber)) {
						foodItem1 = "x Butter Chicken (R78.99) \n";
						count1++;
						ordering = true;
					}
					else if("2".equals(curryNumber)) {
						foodItem2 = "x Chicken Tikka Masala (R82.99) \n";
						count2 ++;
						ordering = true;
					}
					else if("3".equals(curryNumber)) {
						foodItem3 = "x Bunny Chow (R55.00) \n";
						count3++;
						ordering = true;
					}
					else if("4".equals(curryNumber)) {
						ordering = false;
					}
					else {
						System.out.println("Please enter a correct item number");
						ordering = true;
					}	
					
				}while(ordering == true);
				
				//Calculate Food Total
				foodPriceDouble = (double)Math.round(100 *((butterChicken * count1) + (tikkaMasala * count2) + (bunnyChow * count3))) / 100;
				foodTotal = String.valueOf(foodPriceDouble);
				
				//if count is 0 then the food Quantity becomes and empty string
				if (count1 == 0) {
					foodQuanity1 = "";
				}
				else {
					foodQuanity1 = String.valueOf(count1);
				};
				
				if (count2 == 0) {
					foodQuanity2 = "";
				}
				else {
					foodQuanity2 = String.valueOf(count2);
				}
				
				if (count3 == 0) {
					foodQuanity3 = "";
				}
				else {
					foodQuanity3 = String.valueOf(count3);
				}
				
			}	 
			
			// Restaurant info details: city, phone, instructions
			String userCity = Customer.getCustomerCity();
			String foodInstructions = getSpecialInstructions();
			input.close();
			
			//Create new restaurant object
			Restaurant newRestaurant = new Restaurant(userCity,foodName, foodPhone, foodItem1, foodItem2, foodItem3, foodQuanity1, foodQuanity2, foodQuanity3, foodPrice, foodInstructions, foodTotal);
			return newRestaurant;
		
		}
		
		
	//method to retrieve foodName
	public static String getRestaurantName() {
		String foodNameNumber = "";
		String restaurantName = "";
		boolean acceptableRestaurant = true;
		do {
			//ask user and find restaurant name
			System.out.println("Enter the number of the resturant you'd like to order from: \n"
					+ "1. Aesop’s Pizza \n"
					+ "2. Kong Pow Kusine \n"
					+ "3. Hurry My Curry");
			Scanner input = new Scanner(System.in);
			foodNameNumber = input.nextLine();
	
			if("1".equals(foodNameNumber)) {
				restaurantName = "Aesop’s Pizza";
				acceptableRestaurant = true;
			}
			else if("2".equals(foodNameNumber)) {
				restaurantName = "Kong Pow Kusine";
				acceptableRestaurant = true;
			}
			else if("3".equals(foodNameNumber)) {
				restaurantName = "Hurry My Curry";
				acceptableRestaurant = true;
			}
			else {
				System.out.println("You didn't select a correct number. Please select again");
				acceptableRestaurant = false;
			}
			
		}while(acceptableRestaurant == false);
		
			return restaurantName;
		}
	
	//retrieves special instructions
	public static String getSpecialInstructions() {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you have any special instructions");
		String instructions = input.nextLine();
	
		return instructions;
	}

	// print out method for details of the order
	public String restuarantDetails() {
		String foodDetails = "You have ordered the following from " + Restaurant.foodName + " in " + this.userCity + ": \n" + "\n" +
				this.foodQuanity1 + " " + this.foodItem1 + "\n"
				+ this.foodQuanity2 + " " + this.foodItem2 + "\n"
				+ this.foodQuanity3 + " " + this.foodItem3 + "\n" + "\n" +

		"Special Instructions: " + this.foodInstructions + "\n" + "\n" +

		"Total: R" + this.foodTotal + "\n";

		return foodDetails;
	}

	//method to display restaurant phone number
	public String restaurantInfo() {
		String contactRestaurant = "\n" + "If you need to contact the restaurant, their number is " + this.foodPhone + ".";
		return contactRestaurant;
	}
		
}