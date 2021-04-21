package quickFoods;

public class QuickFoods {
	
	public static void main(String[] args) {
//creates invoice		
Functions.createInvoice();

//creates customer file in alphabetical order
Functions.customerTxt();

//creates customer text ordered by city
Functions.customerLocationTxt();

//updates driver text with additional orders
Functions.updateDriver();

	}
	
}
