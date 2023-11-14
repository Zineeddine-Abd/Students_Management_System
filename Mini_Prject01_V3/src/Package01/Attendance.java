package Package01;

import java.util.ArrayList;
import java.util.List;

public class Attendance {
    private List<AttendanceRecord> attendanceRecords = new ArrayList<>();

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public void addAttendanceRecord(String date, boolean isPresent) {
        attendanceRecords.add(new AttendanceRecord(date, isPresent));
    }

    public void displayAttendance(String studentName) {
        System.out.println("Attendance Records for Student: " + studentName);

        for (AttendanceRecord record : attendanceRecords) {
            String date = record.getDate();
            boolean isPresent = record.isPresent();

            String attendanceStatus = isPresent ? "Present" : "Absent";
            System.out.println("Date: " + date + " - " + attendanceStatus);
        }
    }

    public double calculateAttendancePercentage() {
        int totalDays = attendanceRecords.size();
        int presentDays = 0;

        for (AttendanceRecord record : attendanceRecords) {
            if (record.isPresent()) {
                presentDays++;
            }
        }

        if (totalDays == 0) {
            return 0.0;  // To avoid division by zero
        }

        return (double) (presentDays * 100 / totalDays);
    }
}
