package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Attendance;

public class AttendanceService {
    private final List<Attendance> records = new ArrayList<>();

    public boolean recordAttendance(int employeeId, double hours) {
        if (employeeId <= 0 || hours < 0 || hours > 24) return false;
        records.add(new Attendance(employeeId, LocalDate.now(), hours));
        return true;
    }

    public List<Attendance> getRecords() {
        return new ArrayList<>(records);
    }
}
