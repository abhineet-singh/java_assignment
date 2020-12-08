package day3_A1;

public class HousingLoan extends Loan {
	
	private double loanAmount;
	private double loanPeriod;
	
	public HousingLoan(double loanAmount, double loanPeriod, double cibilScore) {
		super(cibilScore);
		this.loanAmount = loanAmount;
		this.loanPeriod = loanPeriod;
	}
	
	@Override
	public double findRateOfInterest() {

		double rateOfInterest = super.findRateOfInterest();
		
		double interestAmount = (rateOfInterest * this.getLoanAmount() * this.getLoanPeriod()) / 100;

		return interestAmount;
		
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(double loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

}
