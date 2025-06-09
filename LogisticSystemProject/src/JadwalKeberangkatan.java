package Dispatch;

import java.time.LocalTime;

public class JadwalKeberangkatan {
    private String scheduleId;
    private LocalTime estimatedTime;

    public JadwalKeberangkatan(String scheduleId, LocalTime estimatedTime) {
        this.scheduleId = scheduleId;
        this.estimatedTime = estimatedTime;
    }

    public String getSchedule() {
        return "Schedule ID: " + scheduleId + ", Estimated Time: " + estimatedTime;
    }

    public void updateTime(LocalTime newTime) {
        this.estimatedTime = newTime;
    }
}