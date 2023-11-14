package Package01;

public class AttendanceRecord {
    private String date;
    private boolean isPresent;

    public AttendanceRecord(String date, boolean isPresent) {
        this.date = date;
        this.isPresent = isPresent;
    }

    public String getDate() {
        return date;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
