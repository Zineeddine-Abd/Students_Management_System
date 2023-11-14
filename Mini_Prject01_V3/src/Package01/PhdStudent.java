package Package01;

public class PhdStudent extends Student {

	private String researchTopic;
    private int researchYears;

    public PhdStudent(String first_name, String last_name, String id, String researchTopic, int researchYear) {
        super(first_name, last_name, id);
        this.researchTopic = researchTopic;
        this.researchYears = researchYear;
    }
    
    //Getters :-------------------------------------
    public String getResearchTopic() {
        return researchTopic;
    }
    
    public int getResearchYears() {
        return researchYears;
    }
    
    //Setters :---------------------------------------
    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public void setResearchYear(int researchYear) {
        this.researchYears = researchYear;
    }

    @Override
    public void displayStudent() {
    	
    	System.out.println("-Speciality : Phd student");
    	System.out.println("-Research Topic : " + researchTopic);
        System.out.println("-Research Years : " + researchYears);
        System.out.println("-Overall Gpa : " + super.getGrades().getOverallgpa());
        System.out.println();
        super.displayStudent();
       
    }
}
