package Package03;

import Package01.Module;
import java.util.List;

public abstract class GradeCalculator {
    
	public abstract void calculateModuleGPA(List<Module> modules , String moduleName);
    
    public double calculateOverallGPA(List<Module> modules) {
        
    	double totalGPA = 0;
        int totalCoef = 0;

        for (Module module : modules) {
            
            totalGPA += module.getModulegpa() * module.getCoef();
            totalCoef += module.getCoef();
        }

        return totalGPA / totalCoef;
    }

}
