package student.studentClassMvc;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	
	
	public static List<Student> getStudents(){
		//create an empty List
		List<Student> students = new ArrayList<>();
		//add sample data
		students.add(new Student("Jon", "Joo", "jonathanjoo@gmail.com"));
		students.add(new Student("Won Sang", "Joo", "wonsangjoo@gmail.com"));
		students.add(new Student("John", "Doe", "JohnDoe@gmail.com"));
		students.add(new Student("Mary", "Sue", "MarySue@gmail.com"));
		//return the list to the calling program
		return students;
	}
}	
