package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int studentID;
	private int gradeYear;
	private ArrayList<Course> enrolledCourses;
	private int balance;
	private static int ID = 1000;
	
	public Student(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("First Name : ");
		firstName = input.nextLine();
		
		System.out.print("Last Name : ");
		lastName = input.nextLine();
		
		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level :");
		gradeYear = input.nextInt();
		
		setstudentID();
		
		System.out.println(firstName + " " + lastName + " " + studentID);
		
		
		input.close();
	}
	
	// getters and setters
	
	public String getName() {
		return firstName;
	}
	public void setName(String name) {
		this.firstName = name;
	}
	public int getgradeYear() {
		return gradeYear;
	}
	public void setgradeYear(int year) {
		this.gradeYear = year;
	}
	public ArrayList<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	private void setstudentID() {
		studentID = Integer.valueOf("" + getgradeYear() + ID);
		ID++;
	}
	public int getstudentID() {
		return studentID;
	}
	public int getBalance() {
		return balance;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
