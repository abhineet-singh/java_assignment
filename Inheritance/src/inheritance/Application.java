package inheritance;

public class Application {

	public static void main(String[] args) {
		
		Student s1 = new Student(101,"Abhineet","88");
		Student s2 = new Student(102,"Abhishek","89");
		Student s3 = new Student(103,"Ankur","90");
		
		Student[] studentList = {s1,s2,s3};
		
		// dataType[] arrayRefVar = new dataType[arraySize];
		Student[] studentList_2 = new Student[3];
		studentList_2[0] = s1;
		studentList_2[1] = s2;
		studentList_2[2] = s3;
		
		StudentService newStudentService = new StudentService();
		
		newStudentService.printStudentList(studentList_2);
		
		System.out.println("==============================");
		
		newStudentService.displayStudentList(studentList[0],studentList[1]);
		
		System.out.println("==============================");
		
		EnhancedStudentService ess = new EnhancedStudentService();
		
		ess.printStudentList(studentList_2);
		
		System.out.println("==============================");
		
		System.out.println(s1);

	}
}

