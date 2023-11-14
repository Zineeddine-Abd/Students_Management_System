package Package01;

public class Module {
    private String name;
    private double examGrade;
    private double tpGrade;
    private double tdGrade;
    private int Coef;
    
    private double module_gpa = 0;

    // Constructors
    public Module(String name, double examGrade, double tpGrade, double tdGrade , int Coef) {
        this.name = name;
        this.examGrade = examGrade;
        this.tpGrade = tpGrade;
        this.tdGrade = tdGrade;
        this.Coef = Coef;
        
    
    }
    
    public Module(String name, double examGrade, double tpGrade, double tdGrade , int Coef, double module_gpa) {
        this.name = name;
        this.examGrade = examGrade;
        this.tpGrade = tpGrade;
        this.tdGrade = tdGrade;
        this.Coef = Coef;
        this.module_gpa = module_gpa;
        
    
    }


    // Getters ;-----------------------------------
    public String getName() {
        return name;
    }

    public double getExamGrade() {
        return examGrade;
    }

    public double getTpGrade() {
        return tpGrade;
    }

    public double getTdGrade() {
        return tdGrade;
    }
    
    public int getCoef() {
        return Coef;
    }
    
    public double getModulegpa() {
        return module_gpa;
    }

    // Setters :---------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setExamGrade(double examGrade) {
        this.examGrade = examGrade;
    }

    public void setTpGrade(double tpGrade) {
        this.tpGrade = tpGrade;
    }

    public void setTdGrade(double tdGrade) {
        this.tdGrade = tdGrade;
    }
    
    public void setCoef(int Coef) {
        this.Coef = Coef;
    }
    
    public void setModule_gpa(double module_gpa) {
        this.module_gpa = module_gpa;
    }
    
    @Override
    public String toString() {
    	
    	return "Module Name : " + name + "\n" + "-Exam grade : " + examGrade + "\n" + "-Tp grade : " + tpGrade + "\n" + "-Td grade : " + tdGrade + "\n" + "-Module Gpa : " + module_gpa + "\n";
    }
}
