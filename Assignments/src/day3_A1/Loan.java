package day3_A1;

public class Loan {
	
	private double cibilScore;

	public Loan() {
	}

	public Loan(double cibilScore) {
		this.cibilScore = cibilScore;
	}
	
	public double findRateOfInterest() {
		
		double rateOfInterest = 0.0;
		
		if(this.getCibilScore() > 500) {
			rateOfInterest = 7.5;
		}
		else {
			rateOfInterest = 8.2;
		}
		
		return rateOfInterest;
	}

	public double getCibilScore() {
		return cibilScore;
	}
	

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

}

