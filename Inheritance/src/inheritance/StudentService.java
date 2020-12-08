package inheritance;

public class StudentService {
	
	public void printStudentList(Student[] students) {
		
		// for (type variable : arrayName)
		for(Student eachStudent : students) {		
			System.out.println(eachStudent);
		}
	}
	
	/*
	 *  Variable Arguments
	 *  accepts 0 or more arguments,
	 *  can be only one variable argument in the method,
	 *  Variable argument must be the last argument
	*/
	public void displayStudentList(Student ...students) {
		
		for(Student eachStudent : students) {		
			System.out.println(eachStudent);
		}
	}

}
