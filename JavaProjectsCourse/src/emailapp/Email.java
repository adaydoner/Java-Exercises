package emailapp;

import java.util.Scanner;


public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = MAILBOX_CAPACITY;
	private String alternateEmail;
	private static final int PASSWORD_LENGTH = 8;
	private static final String COMPANY_NAME = "usercompany";
	private static final int MAILBOX_CAPACITY = 100;
	
	
	/**
	 * Creating a new Email object with first name and last name.
	 * This constructor would ask a department of email user.
	 * @param firstName
	 * @param lastName
	 */
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email created for " + this.firstName + " " +this.lastName + "\n");
		
		this.department = setDepartment();
		
		this.password = generatePassword(PASSWORD_LENGTH);
		System.out.println("Passord : " + this.password);
		
		email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase()+ "." + COMPANY_NAME + ".com";
		
	}
	
	/**
	 * setting department 
	 * 1 for Sales 
	 * 2 for Development 
	 * 3 for Accounting 
	 * 0 for None
	 * 
	 * @return
	 */
	private String setDepartment(){
		int choice = -1;
		while (choice < 0 || 3 < choice ) {
			System.out.print("\nEnter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code : ");
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			input.close();
		}
		
		switch (choice) {
		case 1: return "Sales";
		case 2: return "Development";
		case 3: return "Accounting";
		default: return "Nothing";
		}
	}
	
	/**
	 * it will generate random password , default password length is 8,
	 * @param length
	 * @return
	 */
	private String generatePassword(int length){
		String chars = "ABCDEFGHIJKLMNOPRSTUVYZ0123456789!+%&/()=?.,";
		String password = "";
		for (int i = 0; i < length; i++) {
			password += chars.charAt((int)(Math.random() * chars.length()));
		}
		return password;
	}
	
	/**
	 * showing email instance's values , 
	 * DISPLAY NAME : first name + last name
	 * Company Email : email
	 * Mailbox Capacity = mailbox capacity;
	 */
	public void showInfo(){
		System.out.println( "Display Name : " + firstName + " " + lastName + 
				"\nCompany Email : " + email +
				"\nMailbox Capacity : " + mailboxCapacity);
	}
	
	/*
	 * getters and setters
	 */
	public void setMailboxCapacity(int mailboxCapacity){
		this.mailboxCapacity = mailboxCapacity;
	}
	
	public void setAlternateEmail(String alternateEmail){
		this.alternateEmail = alternateEmail;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	
}
