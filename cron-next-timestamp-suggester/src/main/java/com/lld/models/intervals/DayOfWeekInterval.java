package com.lld.models.intervals;

import com.lld.models.interfaces.Interval;

public class DayOfWeekInterval extends Interval {
    public DayOfWeekInterval(String intervalStr) {
        super(intervalStr);
    }

    @Override
    public int getLowerBoundOfInterval() {
        return 1;
    }

    @Override
    public int getUpperBoundOfInterval() {
        return 7;
    }
}
