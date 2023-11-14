package Package01;

import Package04.*;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String first_name;
	private String last_name;
	private String id;
	private Grade grades;
	private Attendance attendance;
	
	private List<Text> emails;
	private List<Text> smss;
	
	
	public Student(String first_name , String last_name , String id){
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
		this.grades = new Grade();
		this.attendance = new Attendance() ;
		
		emails = new ArrayList<>();
		smss = new ArrayList<>();
		
	}
	
	//Getters :------------------------
	
	public String getFirst_name() {
        return first_name;
    }
	
	public String getLast_name() {
        return last_name;
    }
	
	public String getId() {
        return id;
    }
	
	public Grade getGrades() {
		return grades;
	}
	
	public Attendance getAttendance() {
        return attendance;
    }
	
	public List<Text> getEmail() {
        return emails;
    }
	
	public List<Text> getSms() {
		return smss;
	}
	
	//Setters :------------------------
	
	public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
	
	public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
	
	public void setId(String id) {
        this.id = id;
    }

	public void setGrades(Grade grade) {
		this.grades = grade;
	}
	
	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}
	
	//----------------------------------------------
    
	public void addEmail(Text emailSent) {
		emails.add(emailSent);
	}
	
	public void addSms(Text smsSent) {
		smss.add(smsSent);
	}
	
    @Override
    public String toString() {
    	
    	return("First Name : " + first_name + "\n" + "Last Name : " + last_name + "\n" + "ID : " + id + "\n" + "Grades : " + "\n--------");
    }
    
    public void displayEmails() {
    	
    	int i = 1;
    	String MAGENTA = "\u001B[35m";
    	String BLUE = "\u001B[34m";
    	String RESET = "\u001B[0m";
    	
    	System.out.println();
    	
    	for(Text email : emails ) {
    		
    		System.out.print(MAGENTA + "Email N " + i + "° :" + RESET);
    		if(i == emails.size()) {
    			System.out.print(BLUE + " (Last updated email)" + RESET);
    		}
    		System.out.print("\n----------");
    		System.out.println();
    		
    		email.displayText();
    		System.out.println();
    		
    		i++;
    	}
    }
    
    public void displaySmss() {
    	
    	int i = 1;
    	String MAGENTA = "\u001B[35m";
    	String BLUE = "\u001B[34m";
    	String RESET = "\u001B[0m";
    	System.out.println();
    	
    	for(Text sms : smss ) {
    		
    		System.out.print(MAGENTA + "Sms N " + i + "° :" + RESET);
    		if(i == smss.size()) {
    			System.out.print(BLUE + " (Last updated sms)" + RESET);
    		}
    		System.out.print("\n----------");
    		System.out.println();
    		
    		sms.displayText();
    		System.out.println();
    		
    		i++;
    	}
    }
    
    public void displayStudent() {
    	
    	System.out.println(this);
    	this.grades.displayGrades();
    	this.attendance.displayAttendance(first_name + " " + last_name);
    }

}
