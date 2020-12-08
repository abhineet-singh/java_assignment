package day3_A1;

public class Application {

	public static void main(String[] args) {
		
		HousingLoan newHousingLoan = new HousingLoan(17000,2.5,545.5);
		
		double interest = newHousingLoan.findRateOfInterest();
		
		System.out.println("Interest is:= " + interest);

	}

}
