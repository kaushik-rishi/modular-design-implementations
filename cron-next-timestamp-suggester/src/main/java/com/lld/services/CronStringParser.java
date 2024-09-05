package com.lld.services;

import com.lld.models.cron.Cron;
import com.lld.models.interfaces.Interval;
import com.lld.models.intervals.MinuteInterval;
import com.lld.models.intervals.MonthInterval;
import com.lld.models.intervals.HourInterval;
import com.lld.models.intervals.DayOfMonthInterval;
import com.lld.models.intervals.DayOfWeekInterval;

public class CronStringParser {
    public Cron parse(String cronString) {
        String[] intervals = cronString.split(" ");

        assert intervals.length == 5;

        Cron.CronBuilder cb =  new Cron.CronBuilder();

        return cb.addMinutes(new MinuteInterval(intervals[0]))
                .addHours(new HourInterval(intervals[1]))
                .addDayOfMonth(new DayOfMonthInterval(intervals[2]))
                .addMonth(new MonthInterval(intervals[3]))
                .addDayOfWeek(new DayOfWeekInterval(intervals[4]))
                .build();
    }
}
