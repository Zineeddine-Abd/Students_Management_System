package Package02;

import Package01.*;
import Package01.Module;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class EngineerDataHandler extends DataHandler {

	public static void saveEngineerStudentsToFile(String filename, List<EngineerStudent> students) {
		
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
	        for (EngineerStudent student : students) {
	            // Line 1: Student information (id, first_name, last_name, Major, overall_gpa)
	            writer.write(student.getId() + "," + student.getFirst_name() + "," + student.getLast_name() + "," + student.getMajor() + "," + student.getGrades().getOverallgpa());
	            writer.newLine();

	            // Line 2: Student grades information
	            List<Module> modules = student.getGrades().getModules();
	            for (Module module : modules) {
	                writer.write(module.getName() + "," + module.getCoef() + "," + module.getExamGrade() + "," + module.getTpGrade() + "," + module.getTdGrade() + "," + module.getModulegpa());
	                if (modules.indexOf(module) < modules.size() - 1) {
	                    writer.write(",");
	                }
	            }
	            writer.newLine();

	            // Line 3: Attendance records (0 for absent, 1 for present)
	            Attendance attendance = student.getAttendance();
	            List<AttendanceRecord> records = attendance.getAttendanceRecords();
	            for (AttendanceRecord record : records) {
	                writer.write(record.isPresent() ? "1" : "0");
	                if (records.indexOf(record) < records.size() - 1) {
	                    writer.write(",");
	                }
	            }
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


    
	public static List<EngineerStudent> loadEngineerStudentsFromFile(String filename, List<String> dates) {
        List<EngineerStudent> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line using a comma
                String[] parts = line.split(",");
                
                if (parts.length >= 5) {
                    String id = parts[0];
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String major = parts[3];
                    double overallGpa = Double.parseDouble(parts[4]);
                    
                    EngineerStudent student = new EngineerStudent(firstName, lastName, id, major);
                    
                    // Set overall GPA
                    Grade grade = new Grade();
                    grade.setOverallGpa(overallGpa);
                    student.setGrades(grade);
                    
                    // Line 2: Student grades information
                    line = reader.readLine();
                    // Split the line using a comma
                    parts = line.split(",");
                    
                    if (parts.length >= 6) {
                        for (int i = 0; i < parts.length; i += 6) {
                            String moduleName = parts[i];
                            int coef = Integer.parseInt(parts[i + 1]);
                            double examGrade = Double.parseDouble(parts[i + 2]);
                            double tpGrade = Double.parseDouble(parts[i + 3]);
                            double tdGrade = Double.parseDouble(parts[i + 4]);
                            double moduleGpa = Double.parseDouble(parts[i + 5]);
                            
                            Module module = new Module(moduleName, examGrade, tpGrade, tdGrade, coef, moduleGpa);
                            grade.addModule(module);
                        }
                    }

                    // Line 3: Attendance records (0 for absent, 1 for present) with dates
                    line = reader.readLine();
                    // Split the line using a comma
                    parts = line.split(",");
                    if (line != null) {
                        String[] attendanceParts = line.split(",");
                        Attendance attendance = new Attendance();
                        
                        for (int i = 0; i < dates.size(); i++) {
                            String date = dates.get(i);
                            boolean isPresent = attendanceParts[i].equals("1");
                            attendance.addAttendanceRecord(date, isPresent);
                        }
                        
                        student.setAttendance(attendance);
                    }
                    
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
	
	
	
}
        
