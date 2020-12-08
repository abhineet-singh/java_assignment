package inheritance;

public class EnhancedStudentService extends StudentService {

	@Override
	public void printStudentList(Student[] students) {
		
		for(Student eachStudent : students) {
			print(eachStudent);
		}
	}

	private void print(Student eachStudent) {
		
		System.out.println("roll number " + eachStudent.getRollNumber());
		System.out.println("name " + eachStudent.getName());
		System.out.println("marks scored " + eachStudent.getMarksScored());
		
		return ;
	}

	@Override
	public void displayStudentList(Student... students) {
		
		for(Student eachStudent : students) {
			print(eachStudent);
		}	
	}

	
	
}
