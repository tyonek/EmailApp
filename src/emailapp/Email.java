package emailapp;

import java.util.Scanner;

public class Email {
    // creates objects
    // encapsulate to private so users cannot access directly
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 250;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "testcompany.com";

    // Constructor to receive firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Call a method that asks for the department - return the department
        this.department = setDepartment();

        // Call a method that calls a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("This is your password:" + this.password);

        // Combine elements that generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    // Ask for department
    private String setDepartment() {
        System.out.println("New worker: " + firstName + " | DEPARTMENT CODES: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "Sales";}
        else if (depChoice == 2) { return "Development";}
        else if (depChoice == 3) { return "Accounting";}
        else {return "";}
    }
    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int random = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
    // Set the mailboxCapacity
    public void setMailboxCapacity(int capicity) {
        this.mailboxCapacity = capicity;
    }
    // Set the alternateEmail
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    // Change the password
    public void changePassword(String altPassword) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public  String getPassword() { return password; }

    public String showInfo(){
        return "\nDISPLAY NAME: " + firstName + " " + lastName + " " +
                "\nCOMPANY EMAIL: " + email + " " +
                "\nMAILBOX CAP: " + mailboxCapacity + "mb";
    }
}
