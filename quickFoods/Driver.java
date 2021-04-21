package quickFoods;
//create Driver class
public class Driver {
	static String driverName;
	static String customerLocation;
	
	//Driver Constructor
	public Driver(String driverName, String customerLocation) {
		Driver.driverName = driverName;
		Driver.customerLocation = customerLocation;
	}
	
	//display driver
	public static String displayDriver() {
		String output= driverName +" is nearest to the restaurant and so s/he will be delivering your order to you at:";
		output+="\n"+ customerLocation;
		return output;
	}

}
