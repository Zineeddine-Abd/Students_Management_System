package Package04;

import Package01.*;

public interface NotificationService {
	
	public void SendEmail(Student student , Text email);
	
	public void SendSms(Student student , Text email);
	

}
