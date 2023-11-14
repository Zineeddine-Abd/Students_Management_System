package Package03;

import Package01.Module;
import java.util.List;

public class PhdCalculator extends GradeCalculator {

    @Override
    public void calculateModuleGPA(List<Module> modules , String moduleName) {
    	
    	double Mgpa = 0;
    	for (Module module : modules) {
            
    		if (module.getName().equals(moduleName)) {
                Mgpa = ((module.getTpGrade() + module.getTdGrade() + module.getExamGrade())/3);
                module.setModule_gpa(Mgpa);
            }
        }
    	
    }

    
}
