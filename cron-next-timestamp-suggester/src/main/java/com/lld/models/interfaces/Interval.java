package com.lld.models.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Interval {
    /*
     * Interval can be either of these
     * 1. a range of numbers
     * 2. a list of numbers
     * 3. * - every possible value
     * 4. (* / something) - split interval
     */

    private String intervalString;
    private List<Integer> possibleNumbers; // will include range and list into this
    private Integer frequency; // * = 1, */15 = 15

    public List<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public Interval(String intervalString) {
        this.intervalString = intervalString;
        this.possibleNumbers = new ArrayList<>();
        this.frequency = null;

        this.parseIntervalString();
    }

    public abstract int getLowerBoundOfInterval();
    public abstract int getUpperBoundOfInterval();

    private void parseIntervalString() {
        if (intervalString.charAt(0) == '*') {
            // frequency
            if (intervalString.length() == 1) {
                frequency = 1;
            } else {
                frequency = Integer.parseInt(intervalString.split("/")[1]);
            }

            int lowerBoundOfInterval = getLowerBoundOfInterval();
            int upperBoundOfInterval = getUpperBoundOfInterval();
            while (lowerBoundOfInterval <= upperBoundOfInterval) {
                possibleNumbers.add(lowerBoundOfInterval);
                lowerBoundOfInterval += frequency;
            }
        } else if (intervalString.contains("-")) {
            // range
            String[] bounds = intervalString.split("-");
            assert bounds.length == 2; // one lower and one upper bound
            for (int i = Integer.parseInt(bounds[0]); i <= Integer.parseInt(bounds[1]); ++i) {
                possibleNumbers.add(i);
            }
        } else if (intervalString.contains(",")) {
            // selected
            Arrays.stream(intervalString.split(",")).map(Integer::parseInt).forEach(possibleNumbers::add);
        } else {
            possibleNumbers.add(Integer.parseInt(intervalString));
        }
    }

    @Override
    public String toString() {
        // String.join(",", possibleNumbers)
        return "Interval[" +
                "s = " + intervalString + " " +
                "frequency = " + frequency + " " +
                "range = " + possibleNumbers.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(", "))
                + "]";
    }
}
