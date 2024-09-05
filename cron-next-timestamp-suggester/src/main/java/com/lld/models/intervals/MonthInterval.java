package com.lld.models.intervals;

import com.lld.models.interfaces.Interval;

public class MonthInterval extends Interval {
    public MonthInterval(String intervalStr) {
        super(intervalStr);
    }

    @Override
    public int getLowerBoundOfInterval() {
        return 1;
    }

    @Override
    public int getUpperBoundOfInterval() {
        return 12;
    }
}
