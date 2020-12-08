package day3_A1;

public class HousingLoan extends Loan {
	
	private double loanAmount;
	private double loanPeriod;
	private double cibilScore;
	
	public HousingLoan(double loanAmount, double loanPeriod, double cibilScore) {
		this.loanAmount = loanAmount;
		this.loanPeriod = loanPeriod;
		this.cibilScore = cibilScore;
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

	public double getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(double cibilScore) {
		this.cibilScore = cibilScore;
	}

	
	
	


}
