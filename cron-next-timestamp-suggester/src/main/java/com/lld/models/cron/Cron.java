package com.lld.models.cron;

import com.lld.models.intervals.*;

public class Cron {
    private MinuteInterval minutes;
    private HourInterval hours;
    private DayOfMonthInterval dayOfMonth;
    private MonthInterval month;
    private DayOfWeekInterval dayOfWeek;

    public Cron() {
    }

    public MinuteInterval getMinutes() {
        return minutes;
    }

    public HourInterval getHours() {
        return hours;
    }

    public DayOfMonthInterval getDayOfMonth() {
        return dayOfMonth;
    }

    public MonthInterval getMonth() {
        return month;
    }

    public DayOfWeekInterval getDayOfWeek() {
        return dayOfWeek;
    }

    public void setMinutes(MinuteInterval minutes) {
        this.minutes = minutes;
    }

    public void setHours(HourInterval hours) {
        this.hours = hours;
    }

    public void setDayOfMonth(DayOfMonthInterval dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setMonth(MonthInterval month) {
        this.month = month;
    }

    public void setDayOfWeek(DayOfWeekInterval dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    private Cron(MinuteInterval minutes, HourInterval hours, DayOfMonthInterval dayOfMonth, MonthInterval month, DayOfWeekInterval dayOfWeek) {
        this.minutes = minutes;
        this.hours = hours;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Cron = " + minutes.toString() + "\n" +
                hours.toString() + "\n" +
                dayOfMonth.toString() + "\n" +
                month.toString() + "\n" +
                dayOfWeek.toString();
    }

    public static class CronBuilder {
        Cron c;

        public CronBuilder() {
            c = new Cron();
        }

        public CronBuilder addMinutes(MinuteInterval minutes) {
            c.setMinutes(minutes);
            return this;
        }

        public CronBuilder addHours(HourInterval hours) {
            c.setHours(hours);
            return this;
        }

        public CronBuilder addDayOfMonth(DayOfMonthInterval dayOfMonth) {
            c.setDayOfMonth(dayOfMonth);
            return this;
        }

        public CronBuilder addMonth(MonthInterval month) {
            c.setMonth(month);
            return this;
        }

        public CronBuilder addDayOfWeek(DayOfWeekInterval dayOfWeek) {
            c.setDayOfWeek(dayOfWeek);
            return this;
        }

        public Cron build() {
            return c;
        }
    }
}
