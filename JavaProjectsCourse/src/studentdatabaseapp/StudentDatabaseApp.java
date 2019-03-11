package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabaseApp {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		int numberOfStudents;
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Course> courses = new ArrayList<>();
		
		
		addCourses(courses);
		
		System.out.print("How many students will be there ? :");
		numberOfStudents = input.nextInt();
		for (int i = 0; i < numberOfStudents; i++) {
			students.add(new Student());
		}
		
	}

	private static void addCourses(ArrayList<Course> courses) {
		courses.add(new Course("History 101",600));
		courses.add(new Course("Mathematics 101"));
		courses.add(new Course("English 101"));
		courses.add(new Course("Chemistry 101"));
		courses.add(new Course("Computer Science 101"));
	}
	public int courseIndex(ArrayList<Course> courses, String courseName){
		for (int i = 0; i < courses.size(); i++) {
			if(courses.get(i).getName().equalsIgnoreCase(courseName)){
				return i;
			}
		}
		return 0;
	}
	public int studentIndex(ArrayList<Student> students, String studentName){
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getName().equalsIgnoreCase(studentName)){
				return i;
			}
		}
		return 0;
	}

}
