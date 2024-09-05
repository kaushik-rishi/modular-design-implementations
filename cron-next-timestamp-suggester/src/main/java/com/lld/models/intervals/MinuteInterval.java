package com.lld.models.intervals;

import com.lld.models.interfaces.Interval;

public class MinuteInterval extends Interval {
    public MinuteInterval(String intervalStr) {
        super(intervalStr);
    }

    @Override
    public int getLowerBoundOfInterval() {
        return 0;
    }

    @Override
    public int getUpperBoundOfInterval() {
        return 59;
    }
}
