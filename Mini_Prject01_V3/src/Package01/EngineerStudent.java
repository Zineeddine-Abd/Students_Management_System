package Package01;

public class EngineerStudent extends Student {
	
	    private String major;
	    
	    public EngineerStudent(String first_name, String last_name, String id, String major) {
	        super(first_name, last_name, id);
	        this.major = major;
	    }
	    
	    //Getters :-----------------------------------
	    public String getMajor() {
	        return major;
	    }
	    
	    //Setters :-------------------------------------
	    public void setMajor(String major) {
	        this.major = major;
	    }
	    
	    //----------------------------------------------
	    @Override
	    public void displayStudent() {
	    	System.out.println("-speciality : Engineer student");
	    	System.out.println("-Engineering Major : " + major);
	    	System.out.println("-Overall Gpa : " + super.getGrades().getOverallgpa());
	    	System.out.println();
	        super.displayStudent();
	        
	    }
}


