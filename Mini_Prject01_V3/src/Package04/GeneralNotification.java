package Package04;

import Package01.Student;

public class GeneralNotification {
	
		
		public void SendEmail(Student student , Text email) {
			student.addEmail(email);
			
		}
		
		public void SendSms(Student student , Text sms) {
			student.addSms(sms);
			
		}
	
}
