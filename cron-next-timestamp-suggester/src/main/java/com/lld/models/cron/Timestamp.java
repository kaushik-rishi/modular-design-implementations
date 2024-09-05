package com.lld.models.cron;

public class Timestamp {
    String timestampStr; // 2024-03-14T00:00:00Z
    Integer year;
    Integer month;
    Integer date;
    Integer hour;
    Integer minute;
    String secondsWithTimezone; // stale for now ==  "00Z" in the end

    public Timestamp(String timestampStr) {
        this.timestampStr = timestampStr;
        this.parseTimeStampString();
    }

    private void parseTimeStampString() {
        String date = timestampStr.split("T")[0];
        String time = timestampStr.split("T")[1];

        String[] dateComponents = date.split("-");
        this.year = Integer.parseInt(dateComponents[0]);
        this.month = Integer.parseInt(dateComponents[1]);
        this.date = Integer.parseInt(dateComponents[2]);

        String[] timeComponents = time.split(":");
        this.hour = Integer.parseInt(timeComponents[0]);
        this.minute = Integer.parseInt(timeComponents[1]);
        this.secondsWithTimezone = timeComponents[2];
    }

    @Override
    public String toString() {
        return "Timestamp[" +
         "timestampStr: " + timestampStr + ", " +
         "year: " + year + ", " +
         "month: " + month + ", " +
         "date: " + date + ", " +
         "hour: " + hour + ", " +
         "minute: " + minute + "]";
    }
}
