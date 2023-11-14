package Package01;

import Package03.EngineerCalculator;
import Package03.PhdCalculator;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    
	private List<Module> modules = new ArrayList<>();
	private double overallGpa = 0;
	private EngineerCalculator ECalculator = new EngineerCalculator();
	private PhdCalculator PCalculator = new PhdCalculator();
	
	//Getters:----------------------------------
	
	public List<Module> getModules() {
		return modules;
	}
	public double getOverallgpa() {
		return overallGpa;
	}
	
	//Setters :---------------------------------
    
	public void setOverallGpa(double overallGpa) {
		this.overallGpa = overallGpa;
	}
    
    //------------------------------------------
	
	public void addModule(Module module) {
        modules.add(module);
    }
	
    public void modifyGrades(Module module , double examGrade, double tpGrade, double tdGrade) {
    	
            	
                module.setExamGrade(examGrade);
                module.setTpGrade(tpGrade);
                module.setTdGrade(tdGrade);
                
                
    }
        


    
    public void calculateModuleGPA(String moduleName , int Strategie) {
        
    	if(Strategie == 1) {
    		ECalculator.calculateModuleGPA(modules, moduleName);
    	}
    	else {
    		PCalculator.calculateModuleGPA(modules, moduleName);
    	}
        
    }

    
    public void calculateOverallGPA() {
        
    	double Ogpa = ECalculator.calculateOverallGPA(modules);
    	this.setOverallGpa(Ogpa);
    }
    

    public void displayGrades() {
    	
    	for (Module module : modules) {
            
    		System.out.println(module);
        }
    }

   
}