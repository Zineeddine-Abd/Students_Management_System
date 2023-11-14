package Package02;

import Package01.*;
import Package04.*;
import Package04.GeneralNotification;

import Package01.Module;

import java.util.*;

public class Management {
	
	public static final int ENGINEERS_STRATEGY = 1; 
	public static final int PHDS_STRATEGY = 0; 	        
	
	public static boolean SearchStudent(List<Student> students , String id) {
		
		for(Student student : students) {
			if(student.getId().equals(id)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static boolean SearchModule(List<Module> modules , String searchModuleName) {
		
		for(Module module : modules) {
			if(module.getName().equals(searchModuleName)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static Student returnStudent(List<Student> students , String searchid) {
		
		for(Student student : students) {
			if(student.getId().equals(searchid)) {
				return student;
			}
		}
		
		return null;
	}
	
	
	public static Module returnModule(List<Module> modules , String searchmodule) {
		
		for(Module module : modules) {
			if(module.getName().equals(searchmodule)) {
				return module;
			}
		}
		
		return null;
	}

	
	
	public static void DisplayWithId(List<Student> students , String id) {
		
		boolean found = false;
		//Colors :
		String RED = "\u001B[31m";
		String RESET = "\u001B[0m";// Reset to default color
		
			for(Student student : students) {
				if(student.getId().equals(id)) {
					found = true;
					student.displayStudent();
				}
			}
			
			if(!found) {
				System.out.println();
				System.out.println(RED + "student doesn't exist" + RESET);
				System.out.println();
			}
		
	}
	
	
	public static void correcteGpa(Student student){
		
		List<Module> modules;
		modules = student.getGrades().getModules();
			
			if(student instanceof EngineerStudent) {
				
				for(Module module : modules) {
					
					student.getGrades().calculateModuleGPA(module.getName(), ENGINEERS_STRATEGY);
					
				}
			}
			else {
				
				for(Module module : modules) {
					
					student.getGrades().calculateModuleGPA(module.getName(), PHDS_STRATEGY);
					
				}
				
			}
			
			student.getGrades().calculateOverallGPA();
			
	}
	
	
	public static void correcteGpas(List<Student> students){
		
		
		for(Student student : students) {
			
			correcteGpa(student);
		}
		
	}
	
	
	public static void studentCheck(Student student) {
		
		Text emailText = new Text();
		Text smsText = new Text();
		int excluCounter = 0;
		List<Module> modules = student.getGrades().getModules();
		
		GeneralNotification GNotif = new GeneralNotification();
		
		
		for(Module module : modules) {
			if(module.getExamGrade() < 5) {
				
				excluCounter++;
				emailText.addText("you have an Exclusionary grade of " + module.getExamGrade() + " in " + module.getName());
			}
		}
		if(excluCounter > 0) {
			
			smsText.addText("you have " + excluCounter + " Exclusionary grades , Please check your emails");
		}
		else {
			emailText.addText("you passed this semester , all your moduls are pssed the Exclusionary grade");
			smsText.addText("you passed your semester , please check your emails");
			
		}
			smsText.addText("\nFrom (213) 21 82 38 38");
			emailText.addText("\nFrom Administration@univ-constantine2.dz");
			
			GNotif.SendEmail(student, emailText);
			GNotif.SendSms(student, smsText);
			
			
}
	
	
	public static void studentsCheck(List<Student> students) {
		
		for(Student student : students) {
			
			studentCheck(student);
		}
		
		//but there is no need if they are the same grades with no modification , so we need to get a solution for tis
		
	}
	
	
	public static void SendInfosToEmail(Student student) {
		
		Text emailText = new Text();
		Text smsText = new Text();
		
		List<Module> modules = student.getGrades().getModules();
		List<AttendanceRecord> attendanceRecords = student.getAttendance().getAttendanceRecords();
		
		GeneralNotification GNotif = new GeneralNotification();
	
		
		emailText.addText("Grades : \n--------");
		
		for(Module module : modules) {
			
			emailText.addText(module + "\n");
		}
		
		emailText.addText("Overall gpa : " + student.getGrades().getOverallgpa());
		
		emailText.addText("");
		emailText.addText("Attendance records : " + "\n--------------------");
		
		for(AttendanceRecord record : attendanceRecords) {
			
			String status = record.isPresent() ? "Present" : "Absent";
			emailText.addText(record.getDate() + " : " + status);
		}
		
		smsText.addText("Your grades and attendances have been sent to you email");
		emailText.addText("\nFrom Administration@univ-constantine2.dz");
		
		smsText.addText("\nFrom (213) 21 82 38 38");
		
		GNotif.SendEmail(student, emailText);
		GNotif.SendSms(student, smsText);
		
	}
	
	
	
}
