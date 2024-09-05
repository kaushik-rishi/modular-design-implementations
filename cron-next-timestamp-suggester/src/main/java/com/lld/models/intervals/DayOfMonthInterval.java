package com.lld.models.intervals;

import com.lld.models.interfaces.Interval;

public class DayOfMonthInterval extends Interval {
    public DayOfMonthInterval(String intervalString) {
        super(intervalString);
    }

    public int getLowerBoundOfInterval() {
        return 1;
    }

    public int getUpperBoundOfInterval() {
        return 31;
    }
}
