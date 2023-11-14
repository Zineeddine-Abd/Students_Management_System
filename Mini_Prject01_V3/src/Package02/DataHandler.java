package Package02;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class  DataHandler{
	
		// j'ai pas mait abstract parceque je veut que les method sont static dans les sou classes

		public static List<String> sortedAttendanceDates(Map<String, Boolean> attendanceRecords) {
	        return attendanceRecords.keySet()
	                .stream()
	                .sorted()
	                .collect(Collectors.toList());
	    }
	    

}

