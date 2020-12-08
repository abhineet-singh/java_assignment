package inheritance;

public class Student {
	
	private int rollNumber;
	private String name;
	private String marksScored;
	
	public Student() {
		super();
	}

	public Student(int rollNumber, String name, String marksScored) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.marksScored = marksScored;
	}
	
	@Override  // check if the constraints matches of the overrides method
	public String toString() {	
		return (this.rollNumber + " " + this.name + " " + this.marksScored);
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(String marksScored) {
		this.marksScored = marksScored;
	}

}
