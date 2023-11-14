package Package01;
import Package02.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<EngineerStudent> engineerStudents = new ArrayList<>();
        List<PhdStudent> phdStudents = new ArrayList<>();
        List<Module> modulesEngineer = new ArrayList<>();
        List<Module> modulesPhd = new ArrayList<>();
        List<String> dates = generateDates();
        
        String searchId  = "None";
        Student searchStudent = null;
        Module searchModule = null;
        int respond = 1;

        // Create modules for Enginners Students
        modulesEngineer.add(new Module("Analyse03", 0, 0, 0, 5));
        modulesEngineer.add(new Module("Algebre03", 0, 0, 0, 4));
        
        // Create modules for Phd Student
        modulesPhd.add(new Module("Statistiques", 0, 0, 0, 3));
        modulesPhd.add(new Module("System d'exploitation", 0, 0, 0, 5));
        modulesPhd.add(new Module("Algorithmique", 0, 0, 0, 5));
        
        final String CORRECT_USER = "Admin21";
        final String CORRECT_PASSWORD = "Admin@21";
        final int MAX_LOGIN_ATTEMPTS = 3;
        
        int LoginChoice = 0;
        String userName = "user";
        String password = "password";
        int attempts = 0;
        int respondManager = 0;
        boolean exists;
		String passcode = "None";
		
		//Colors :
		String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String MAGENTA = "\u001B[35m";
        
        String RESET = "\u001B[0m";// Reset to default color

	
        	
        while(respondManager == 0) {
        	LoginChoice = 0;
        	
        do {
        	do {
        		System.out.println(BLUE + "------------------------------ Welcome to the student management program ------------------------------");
        		System.out.println();
        		System.out.println("                              Universite Abdelhamid Mehri - Constantine 2");
        		System.out.println("                                             Faculte NTIC" + RESET);
        		System.out.println();
        
        		System.out.println(BLUE + "LOGIN AS :" + RESET);
        		System.out.println(BLUE + "---------" + RESET);
        		System.out.print(YELLOW);
        		System.out.println("1- ADMINISTRATOR");
        		System.out.println("2- STUDENT");
        		System.out.print(RESET);
        		System.out.println();
        		System.out.println(RED + "3- Exit the program" + RESET);
        		System.out.println();
        		System.out.print("YOUR CHOICE : ");
        		LoginChoice = scanner.nextInt();
        		scanner.nextLine();
        		System.out.println();
            
        		if(LoginChoice == 2 && students.size() == 0) {
        			System.out.println();
        			System.out.println(RED + "(Sorry , you can't connect as astudent becasue the administration did not upload the students lists yet)" + RESET);
        			System.out.println();
        		 	 
        		}
        		
        	}while(LoginChoice == 2 && students.size() == 0);
        	
      
        	switch (LoginChoice) {
        
        		case 1:
        			attempts = 0;
        		
        				do {
   
        					System.out.println();
        					System.out.print("-USER NAME : " + YELLOW);
        					userName = scanner.nextLine();
        					System.out.print(RESET + "-PASSWORD : " + YELLOW);
        					password = scanner.nextLine();
        					System.out.println(RESET);
        		
        					if(!userName.equals(CORRECT_USER) || !password.equals(CORRECT_PASSWORD)) {
        			
        						attempts++;
        						if(attempts == MAX_LOGIN_ATTEMPTS) {
        				
        							System.out.println("Program terminated");
        							System.out.println(RED + "(3 login mismatche detected)" + RESET);
        		                    scanner.close(); // Close the scanner
        		                    System.exit(0);
        		                    
        						}
        						
        						System.out.println(RED + "(User Name or Password is inccorect)");
        						System.out.println("Please try again" + RESET);
        				
        					}
        				
        				}while(!userName.equals(CORRECT_USER) || !password.equals(CORRECT_PASSWORD));
        			
        				break;
        	
        		case 2:
        			attempts = 0;
        		
            			do {
            				System.out.print("-STUDENT ID : " + YELLOW);
            				userName = scanner.nextLine();
            				System.out.print(RESET + "-PASSWORD : " + YELLOW);
            				password = scanner.nextLine();
            				System.out.println(RESET);
            			
            				exists = Management.SearchStudent(students, userName);
            			
            				if(exists) {
            					searchStudent = Management.returnStudent(students, userName);
            					passcode = searchStudent.getFirst_name() + "@" + searchStudent.getLast_name();
            		
            					if(!password.equals(passcode)) {
            			
            						attempts++;
            						if(attempts == MAX_LOGIN_ATTEMPTS) {
            				
            							System.out.println(RED + "(Program terminated)" + RED);
            							System.out.println(RED + "(3 login mismatche detected)" + RESET);
            		                    scanner.close(); // Close the scanner
            		                    System.exit(0);
            		                    break;
            						}
            						
            						System.out.println(RED + "Student id or Password is inccorect");
            						System.out.println("Please try again" + RESET);
            						System.out.println();
            				
            					}
            				}
            			
            				if(!exists) {
            				
            					attempts++;
            					if(attempts == MAX_LOGIN_ATTEMPTS) {
        				
            						scanner.close();
            						System.exit(0);
            					}
        			
            					System.out.println(RED + "Student id or Password is inccorect");
            					System.out.println("Please try again" + RESET);
            					System.out.println();
            				}
            				
            			}while(!exists || !password.equals(passcode));
            			
            			break;
            	
        		case 3 :
        			System.out.println();
        			System.out.println(GREEN + "(Program terminated)" + RESET);
                    scanner.close(); // Close the scanner
                    System.exit(0);
                    break;
            			
        		default:
        			System.out.println();
                    System.out.println(RED + "Invalid choice. Please choose a valid option." + RESET);
                    
                    break;
        		
        	
        	}
        	
        }while(LoginChoice != 1 && LoginChoice != 2);
        
        System.out.println(GREEN + "(Loged in Succesefuly)" + RESET);
        System.out.println();
        
        	respondManager = 1;
        	if(LoginChoice == 2) {
        		
        		while(respondManager == 1) {
        		
	        		System.out.println("|Options:--------------------------");
		            System.out.println("|1. See my : |--> 1- grades");
		            System.out.println("|            |--> 2- attendances");
		            System.out.println("|            |--> 3- emails");
		            System.out.println("|            |--> 4- SMSs");
		            System.out.println("|");
		            System.out.println("|5- send my data to my email");
		            
		            System.out.println();
		            System.out.print("Enter your choice: ");
		            int choice = scanner.nextInt();
		            scanner.nextLine(); // Consume the newline
		            
		            switch(choice) {
		            	
		            case 1:
		            	
		            	if(Management.SearchStudent(students, userName)) {
		            		
		            		searchStudent = Management.returnStudent(students, userName);
		            		System.out.println();
		            		System.out.println("My grades :");
		            		System.out.println("-----------");
		            		searchStudent.getGrades().displayGrades();
		            		System.out.println("Overall gpa : " + searchStudent.getGrades().getOverallgpa());
		            		System.out.println();
		            	}
		            	else {
		            		System.out.println(RED + "(Student doesn't exist)" + RESET);
		            		System.out.println();
		            	}
		            	
		            	break;
		            
		            case 2:
		            	
		            	if(Management.SearchStudent(students, userName)) {
		            		
		            		searchStudent = Management.returnStudent(students, userName);
		            		System.out.println();
		            		System.out.println("My attendances records :");
		            		System.out.println("-----------------------");
		            		searchStudent.getAttendance().displayAttendance(searchStudent.getFirst_name() + " " + searchStudent.getLast_name());
		            		System.out.println();
		            	}
		            	else {
		            		System.out.println(RED + "(Student doesn't exist)" + RESET);
		            		System.out.println();
		            	}
		            	
		            	break;
		            	
		            case 3:
		            	
		            	if(Management.SearchStudent(students, userName)) {
	                    	
	                    	searchStudent = Management.returnStudent(students, userName);
	                    	if(searchStudent.getEmail().size() == 0) {
	                    		System.out.println();
	                    		System.out.println(RED + "email inbox is empty" + RESET);
	                    		System.out.println();
	                    	}
	                    	else {
	                    	System.out.println();
	                    	System.out.println("MY Emails : ");
	                    	System.out.println("-----------");
	                    	searchStudent.displayEmails();
	                    	}
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println(RED + "Student doesn't exist" + RESET);
	                    	System.out.println();
	                    }
	                    break;
		            	
		            case 4:
		            	
		            	if(Management.SearchStudent(students, userName)) {
	                    	
	                    	searchStudent = Management.returnStudent(students, userName);
	                    	if(searchStudent.getEmail().size() == 0) {
	                    		System.out.println();
	                    		System.out.println(RED + "Sms inbox is empty" + RESET);
	                    		System.out.println();
	                    	}
	                    	else {
	                    	System.out.println();
	                    	System.out.println("MY Smss : ");
	                    	System.out.println("-----------");
	                    	searchStudent.displaySmss();
	                    	}
	                    }
	                    else {
	                    	System.out.println();
	                    	System.out.println(RED + "Student doesn't exist" + RESET);
	                    	System.out.println();
	                    }
	                    break;
		            	
		            	
		            case 5:
		            	
		            	if(Management.SearchStudent(students, userName)) {
		            		
		            		searchStudent = Management.returnStudent(students, userName);
		            		Management.SendInfosToEmail(searchStudent);
		            		System.out.println();
		            		System.out.println(GREEN + "(your data have been sent succesfully)" + RESET);
		            		System.out.println();
		            	}
		            	else {
		            		System.out.println(RED + "(Student doesn't exist)" + RESET);
		            		System.out.println();
		            	}
		            	
		            	break;
	   
		            	
		            default:
	                    System.out.println(RED + "Invalid choice. Please choose a valid option." + RESET);
	                    break;
	        		}
		            
		            do {
		            	if(respondManager != 1 && respondManager != 0) {
		            		System.out.println();
		            		System.out.println(RED + "Please selecte 1(continue) and 0(log out)" + RESET);
		            	}
		            	System.out.println();
		            	System.out.print("do you want to continue or Log out (1/0) : ");
		            	respondManager = scanner.nextInt();
		            	scanner.nextLine();
		            	System.out.println();
		            }while(respondManager != 1 && respondManager != 0);
        	
        		}
        		
        		
        	}
        	else {

        		while (respondManager == 1) {
        			System.out.println("------------------------------------SERVICES------------------------------------");
        	        System.out.println("| 1- Add a student\t\t\t| 4- Display all students' informations");
        	        System.out.println("| 2- modify grades for a student\t| 5- Display Students' Attendances by type ");
        	        System.out.println("| 3- modify attendance for a student\t| 6- Display student by ID");
        	        System.out.println("|");
        	        System.out.println("|7- Save Students to a file (separate files for each type)");
        	        System.out.println("|8- Load students from a file (separate files for each type)");
        	        System.out.println("|");
        	        System.out.println(RED + "|9- EXIT" + RESET);
        	        
        	        System.out.println();
        	        System.out.print("Enter your choice : ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline
	            System.out.println();
	
	            switch (choice) {
	                case 1:
	                	String firstName = "None";
	                	String lastName = "None";
	                	String id = "None";
	                	
	                		System.out.print("-Enter first name: ");
	                		firstName = scanner.nextLine();
	                    	System.out.print("-Enter last name: ");
	                    	lastName = scanner.nextLine();
	                    	do {
	                    	System.out.print("-Enter student ID: ");
	                    	id = scanner.nextLine();
	                    	System.out.println();
	                    
	                    	// Check if the ID already exists
	                    	if(Management.SearchStudent(students, id)) {
	                    		System.out.println();
	                    		System.out.println(RED + "student exists with this id" + RESET);
	                    		System.out.println();
	                    		System.out.print("do you want to to enter another id (0/1) : ");
	                    		respond = scanner.nextInt();
	                    		scanner.nextLine();
	                    		System.out.println();
	                    		
	                    		if (respond == 0) {
	                    			break;
	                    		}
	                    		
	                    	}
	                    	else {
	                    		break;
	                    	}
	                	
	                    	}while(true);
	                    
	                    if(respond != 1) {
	                    	respond = 1;//for the nexte mistakes
	                    	break;
	                    }
	                    
	                    System.out.println("Select the type of student:");
	          
	                    System.out.println("1. Engineer Student");
	                    System.out.println("2. PhD Student");
	                    System.out.println();
	                    System.out.print("Type : ");
	                    int studentTypeChoice = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline
	                    System.out.println();
	                    
	                    Student newStudent = null;
	                    switch (studentTypeChoice) {
	  
	                        case 1:
	                            System.out.print("-Enter major: ");
	                            String major = scanner.nextLine();
	                            newStudent = new EngineerStudent(firstName, lastName, id, major);
	                            engineerStudents.add((EngineerStudent) newStudent);
	                            System.out.println();
	                            
	                            // Assign the modules
	                            Grade Engineergrade = new Grade();
	                            for (Module module : modulesEngineer) {
	                                double examGrade, tpGrade, tdGrade;
	                       
	                                
	                                	System.out.println("Enter grades for " + module.getName() + " :");
	                                	System.out.println("---------------------------------\n");
	                                do {	
	                                    System.out.print("-Enter exam grade : ");
	                                    examGrade = scanner.nextDouble();
	                                    scanner.nextLine(); // Consume the newline
	                                } while (examGrade < 0 || examGrade > 20);
	                                
	                                do {
	                                    System.out.print("-Enter tp grade : ");
	                                    tpGrade = scanner.nextDouble();
	                                    scanner.nextLine(); // Consume the newline
	                                } while (tpGrade < 0 || tpGrade > 20);
	                                
	                                do {
	                                    System.out.print("-Enter td grade : ");
	                                    tdGrade = scanner.nextDouble();
	                                    scanner.nextLine(); // Consume the newline
	                                } while (tdGrade < 0 || tdGrade > 20);
	                                
	                                Engineergrade.addModule(new Module(module.getName(), examGrade, tpGrade, tdGrade, module.getCoef()));
	                                Engineergrade.calculateModuleGPA(module.getName() , 1);
	                                
	                                System.out.println();
	                            }
	                            
	                            Engineergrade.calculateOverallGPA();
	                            newStudent.setGrades(Engineergrade);
	                            break;
	                            
	                        case 2:
	                            System.out.print("-Enter research topic: ");
	                            String researchTopic = scanner.nextLine();
	                            System.out.print("-Enter research years: ");
	                            int researchYears = scanner.nextInt();
	                            scanner.nextLine(); // Consume the newline
	                            newStudent = new PhdStudent(firstName, lastName, id, researchTopic, researchYears);
	                            phdStudents.add((PhdStudent) newStudent);
	                            System.out.println();
	                            
	                         // Assign the modules
	                            Grade Phdgrade = new Grade();
	                            for (Module module : modulesPhd) {
	                                double examGrade, tpGrade, tdGrade;
	                                
	                                System.out.println("Enter grades for " + module.getName() + " :");
                                	System.out.println("------------------------------------------\n");
                                	
	                                do {
	                                    System.out.print("Enter exam grade for : ");
	                                    examGrade = scanner.nextDouble();
	                                    scanner.nextLine(); // Consume the newline
	                                } while (examGrade < 0 || examGrade > 20);
	                                
	                                do {
	                                    System.out.print("Enter tp grade for : ");
	                                    tpGrade = scanner.nextDouble();
	                                    scanner.nextLine(); // Consume the newline
	                                } while (tpGrade < 0 || tpGrade > 20);
	                                
	                                do {
	                                    System.out.print("Enter td grade for : ");
	                                    tdGrade = scanner.nextDouble();
	                                    scanner.nextLine(); // Consume the newline
	                                } while (tdGrade < 0 || tdGrade > 20);
	                                
	                                Phdgrade.addModule(new Module(module.getName(), examGrade, tpGrade, tdGrade, module.getCoef()));
	                                Phdgrade.calculateModuleGPA(module.getName() , 2);
	                                
	                                System.out.println();
	                            }
	                            
	                            Phdgrade.calculateOverallGPA();
	                            newStudent.setGrades(Phdgrade);
	                            break;
	                            
	                        default:
	                        	System.out.println();
	                            System.out.println(RED + "Invalid student type choice." + RESET);
	                            System.out.println();
	                            break;
	                    }
	                    
	                    if(studentTypeChoice < 1 || studentTypeChoice > 2) {
	                    	break; // exit the case 1
	                    }
	                    
	                    // Initialize Attendance
	                    newStudent.setAttendance(new Attendance());
	
	                    System.out.println();
	                    // Assign the generated attendance dates
	                    Attendance attendance = new Attendance();
	                    
	                    for (String date : dates) {
	                        System.out.print("Enter '(1: present)' or '(0: absent)' for " + date + ": ");
	                        boolean isPresent = scanner.nextInt() == 1;
	                        attendance.addAttendanceRecord(date, isPresent);
	                    }
	                    newStudent.setAttendance(attendance);
	                    
	                    students.add(newStudent);
	                    System.out.println();
	                    System.out.println(GREEN + "Student created successfully!" + RESET);
	                    System.out.println();
	                    
	                    Management.studentCheck(newStudent);
	                    System.out.println();
	                    break;
	                    
	                case 2:
	                	System.out.print("-Enter student ID: ");
	                    searchId = scanner.nextLine(); // but why its known in the case 4
	                    System.out.println();
	                    
	                	if(Management.SearchStudent(students, searchId)) {
	                		searchStudent = Management.returnStudent(students, searchId);
	                		
	                		System.out.print("Please enter the name of the module you want to change : ");
	                		String searchModuleName = scanner.nextLine();
	                		System.out.println();
	                		
	                		if(Management.SearchModule(searchStudent.getGrades().getModules(), searchModuleName)) {
	                			searchModule = Management.returnModule(searchStudent.getGrades().getModules(), searchModuleName);
	                			
	                			System.out.println("Please enter the grades you want to change with : ");
	                			System.out.print("-Exam grade : ");
	                			double examGrade = scanner.nextDouble();
	                			scanner.nextLine();
	                			System.out.print("-Tp grade : ");
	                			double tpGrade = scanner.nextDouble();
	                			scanner.nextLine();
	                			System.out.print("-Td grade : ");
	                			double tdGrade = scanner.nextDouble();
	                			scanner.nextLine();
	                			System.out.println();
	                			
	                
	                			searchStudent.getGrades().modifyGrades(searchModule , examGrade , tpGrade , tdGrade);
	                			Management.correcteGpa(searchStudent);
	                			
	                			Management.studentCheck(searchStudent);
	                			System.out.println(GREEN + "(Grades have been changed succesefully)" + RESET);
	                			System.out.println();
	                	
	                		
	                		}
	                		else {
	                			System.out.println();
	                			System.out.println(RED + "module doesn't exist" + RESET);
	                			System.out.println();
	                		}
	                	}
	                	else {
	                		System.out.println();
	                		System.out.println(RED + "student doesn't exist" + RESET);
	                		System.out.println();
	                	}
	                	System.out.println();
	                	break;
	                	
	                case 3:
	                	System.out.print("-Enter student ID: ");
	                    searchId = scanner.nextLine(); // but why its known in the case 4
	                    System.out.println();
	                    
	                    if(Management.SearchStudent(students, searchId)) {
	                    	
	                    	searchStudent = Management.returnStudent(students, searchId);
	                    	
	                    	// Assign the generated attendance dates
		                    Attendance studentattendance = new Attendance();
		                    
		                    for (String date : dates) {
		                        System.out.print("Enter '(1: present)' or '(0: absent)' for " + date + ": ");
		                        boolean isPresent = scanner.nextInt() == 1;
		                        studentattendance.addAttendanceRecord(date, isPresent);
		                    }
		                    searchStudent.setAttendance(studentattendance);
		                    System.out.println(GREEN + "(Attendance have been changed succesefully)" + RESET);
                			System.out.println();
		                    
	                    	
	                    }
	                    else {
	                    	System.out.println();
	                		System.out.println(RED + "student doesn't exist" + RESET);
	                		System.out.println();
	                    }
	                    System.out.println();
	                	break;
	                
	                case 4:
	                    System.out.println("Select the type of student to display (1/2) , or enter 0 to display all students : ");
	          
	                    System.out.println("1. Engineer Student");
	                    System.out.println("2. PhD Student");
	                    System.out.println();
	                    System.out.print("Choice : ");
	                    int displayType = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline
	                    System.out.println();
	                    
	                    switch (displayType) {
	                        case 0:
	                        	if(!(students.size() == 0)) {
	                        		System.out.println(MAGENTA + "List of students : ");
	                        		System.out.println("------------------" + RESET);
	                        		System.out.println();
	                        		for (Student student : students) {
	                        			student.displayStudent();
	                        			System.out.println(MAGENTA + "-----------------------------------" + RESET);
	                        			System.out.println();
	                        		}
	                        	}
	                        	else {
	                        		System.out.println();
	                        		System.out.println(RED + "No student added yet" + RESET);
	                        		System.out.println();
	                        	}
	                            break;
	                            
	                        case 1:
	                        	if(!(engineerStudents.size() == 0)) {
	                        		System.out.println(MAGENTA + "List of engineer students : ");
	                        		System.out.println("---------------------------" + RESET);
	                        		System.out.println();
	                        		for (EngineerStudent student : engineerStudents) {
	                        			student.displayStudent();
	                        			System.out.println(MAGENTA + "----------------------------------" + RESET);
	                        			System.out.println();
	                        		}
	                        	}
	                        	else {
	                        		System.out.println();
	                        		System.out.println(RED + "No student added yet" + RESET);
	                        		System.out.println();
	                        	}
	                            break;
	                            
	                        case 2:
	                        	if(!(phdStudents.size() == 0)) {
	                        		System.out.println(MAGENTA + "List of phds students : ");
	                        		System.out.println("-----------------------" + RESET);
	                        		System.out.println();
	                        		for (PhdStudent student : phdStudents) {
	                        			student.displayStudent();
	                        			System.out.println(MAGENTA + "----------------------------------" + RESET);
	                        			System.out.println();
	                        		}
	                        	}
	                        	else {
	                        		System.out.println();
	                        		System.out.println(RED + "No student added yet" + RESET);
	                        		System.out.println();
	                        	}
	                        	break;
	                        	
	                        default:
	                        	System.out.println();
	                            System.out.println(RED + "Invalid student type choice." + RED);
	                            System.out.println();
	                            break;
	                    }
	                    System.out.println();
	                    break;
	                    
	                case 5:
	                    System.out.println("Select the type of student to display attendances (1/2):");
	                    
	                    System.out.println("1. Engineer Student");
	                    System.out.println("2. PhD Student");
	                    System.out.println();
	                    System.out.print("Choice : ");
	                    int attendanceType = scanner.nextInt();
	                    scanner.nextLine(); // Consume the newline
	
	                    switch (attendanceType) {
	                        case 1:
	                        	if(!(students.size() == 0)) {
	                        		System.out.println();
	                        		System.out.println(MAGENTA + "engineer students attendances : ");
	                        		System.out.println("-------------------------------" + RESET);
	                        		System.out.println();
	                        		for (EngineerStudent student : engineerStudents) {
	                        			student.getAttendance().displayAttendance(student.getFirst_name() + " " + student.getLast_name());
	                        			System.out.println(MAGENTA + "--------------------------------------" + RESET);
	                        			System.out.println();	                            
	                                }
	                        	}
	                        	else {
	                        		System.out.println();
	                        		System.out.println(RED + "No student added yet" + RESET);
	                        		System.out.println();
	                        	}
	                            break;
	                            
	                        case 2:
	                        	if(!(students.size() == 0)) {
	                        		System.out.println();
	                        		System.out.println(MAGENTA + "phds students attendances : ");
	                        		System.out.println("---------------------------" + RESET);
	                        		System.out.println();
	                        		for (PhdStudent student : phdStudents) {
	                        			student.getAttendance().displayAttendance(student.getFirst_name() + " " + student.getLast_name());
	                        			System.out.println(MAGENTA + "--------------------" + RESET);
	                        			System.out.println();	                            
	                                }
	                        	}
	                        	else {
	                        		System.out.println();
	                        		System.out.println(RED + "No student added yet" + RESET);
	                        		System.out.println();
	                        	}
	                            break;
	                            
	                        default:
	                        	System.out.println();
	                            System.out.println(RED + "Invalid student type choice." + RED);
	                            System.out.println();
	                            break;
	                    }
	                    System.out.println();
	                    break;
	
	                case 6:
	                    System.out.print("-Enter student ID : ");
	                    searchId = scanner.nextLine();
	                    System.out.println();
	                    
	                    Management.DisplayWithId(students, searchId);
	                    System.out.println();
	                    break;
	
	                case 7:
	                    if(engineerStudents.isEmpty() || phdStudents.isEmpty()) {
	                    	System.out.println();
	                    	System.out.println(RED + "one of the lists are not filled , please complete fiiling for saving" + RESET);
	                    	System.out.println();
	                    }
	                    else {
	                	saveStudentsToFiles(engineerStudents, phdStudents);
	                	System.out.println();
	                    System.out.println(GREEN + "Students saved" + RESET);
	                    System.out.println();
	                    }
	                    break;
	
	                case 8:
	                	String namefile1 = "EngineerStudents.txt";
	                	String namefile2 = "PhdStudents.txt";
	                	
	                    File file1 = new File(namefile1);
	                    File file2 = new File(namefile2);
	                    
	                    if(!file1.exists() || !file2.exists() || file1.length() == 0 || file2.length() == 0) {
	                    	if(!file1.exists()) {
	                    		System.out.println(namefile1 + RED + " doesn't exists" + RESET);
	                    	}
	                    
	                    	if(!file2.exists()) {
	                    		System.out.println(namefile2 + RED +  " doesn't exists" + RESET);
	                    	}
	                    		
	                    	if(file1.length() == 0) {
	                    		System.out.println(namefile1 + RED + " is empty" + RESET);
	                    	}
	                    	
	                    	if(file2.length() == 0) {
	                    		System.out.println(namefile2 + RED + " is empty" + RESET);
	                    	}
	                    }
	                    else {
	                	loadStudentsFromFiles(engineerStudents, phdStudents , students , dates);
	                	System.out.println();
	                    System.out.println(GREEN + "Students loaded" + RESET);
	                    }
	                    System.out.println();
	                    break;
	
	                case 9:
	                	System.out.println();
	                    System.out.println(GREEN + "(Program terminated)" + RESET);
	                    System.out.println();
	                    scanner.close(); // Close the scanner
	                    System.exit(0);
	                    break;
	
	                default:
	                	System.out.println();
	                    System.out.println(RED + "Invalid choice. Please choose a valid option." + RESET);
	                    System.out.println();
	                    break;
	            }
	            
	            do {
	            	if(respondManager != 1 && respondManager != 0) {
	            		System.out.println();
	            		System.out.println(RED + "Please selecte 1(continue) and 0(log out)" + RESET);
	            	}
	            	
	            	System.out.print("do you want to continue as an Admin or Log out (1/0) :");
	            	respondManager = scanner.nextInt();
	            	scanner.nextLine();
	            	System.out.println();
	            }while(respondManager != 1 && respondManager != 0);
	            
	        }
	    }
       
    }
    
}
    
    
    //Local methods :--------------------------------------------------------------------
    
    private static List<String> generateDates() {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate = sdf.parse("25/10/2023");
            Date endDate = sdf.parse("05/11/2023");
            long interval = 24 * 1000 * 60 * 60; // 24 hours in milliseconds

            long curTime = startDate.getTime();
            while (curTime <= endDate.getTime()) {
                Date date = new Date(curTime);
                dates.add(sdf.format(date));
                curTime += interval;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }
    
    
    private static void saveStudentsToFiles(
    	    List<EngineerStudent> engineerStudents, 
    	    List<PhdStudent> phdStudents
    	) {
    
    	        EngineerDataHandler.saveEngineerStudentsToFile("EngineerStudents.txt", engineerStudents);
    	        PhdDataHandler.savePhdStudentsToFile("PhdStudents.txt", phdStudents);

    }  



    private static void loadStudentsFromFiles(
    	    List<EngineerStudent> engineerStudents, 
    	    List<PhdStudent> phdStudents,
    	    List<Student> students,
    	    List<String> dates
    	) {
    	    String engineerStudentsFile = "EngineerStudents.txt";
    	    String phdStudentsFile = "PhdStudents.txt";

    	    List<EngineerStudent> loadedEngineerStudents = EngineerDataHandler.loadEngineerStudentsFromFile(engineerStudentsFile,dates);
    	    List<PhdStudent> loadedPhdStudents = PhdDataHandler.loadPhdStudentsFromFile(phdStudentsFile,dates);
    	    
    	    engineerStudents.clear();
    	    engineerStudents.addAll(loadedEngineerStudents);
    	    phdStudents.clear();
    	    phdStudents.addAll(loadedPhdStudents);
    	    
    	    students.clear();
    	    students.addAll(loadedPhdStudents);
    	    students.addAll(loadedEngineerStudents);
    	    
    	    Management.correcteGpas(students);
    	    Management.studentsCheck(students);
    	    
    	}

    
}
