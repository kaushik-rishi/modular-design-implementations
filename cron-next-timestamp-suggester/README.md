# Design and Implement Cron Expression Parser

- Difficulty: Medium

## Problem Description
Design and implement a cron expression parser that takes a cron expression and a current timestamp as input and determines the next execution time for the cron job.

Cron expressions consist of five fields: minute, hour, day of the month, month, and day of the week, in that order. Each field can have a specific value, a range (-), a list (,), or an asterisk (*) which represents "every" possible value.

Your cron parser should support the following features:
- Parsing standard cron expressions with 5 fields.
- Handling ranges and lists in each field.
- Support for the * character to denote any value in a field.
- Calculation of the next execution time from a given timestamp, taking into account the current time and the cron expression.
> Assume the cron expressions are in UTC time and the input timestamp is also provided in UTC.

### Example:
- Input Cron Expression: `*/15 0 1,15 * 1-5`
- Input Timestamp: `2024-03-14T00:00:00Z`
- Output: `2024-03-15T00:00:00Z`

This means the job runs every 15 minutes (`*/15`) at midnight (`0`) on the 1st and 15th of every month, on days Monday to Friday (`1-5`). Given the input timestamp, the next execution time is at midnight on the 15th of March 2024.
Follow-up:

Print the next nth instance when a string is passed


## Approach

- Constraint based `Interval` model
  - To help, invalidate a wrong cron tab passed
    - if we don't need the feature, we wouldn't need constraints
  - we would also have a scope of valid numbers for each kind of interval
  - `minutes` - 0 to 60
  - `hours` - 0 to 24
  - `daysOfMonth` - 1 to 30/31
  - `month` - 1 to 12 
  - `daysOfWeek` - 1 to 7
