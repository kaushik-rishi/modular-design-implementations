package com.lld;

import com.lld.models.cron.Cron;
import com.lld.models.cron.Timestamp;
import com.lld.services.CronStringParser;

public class Main {
    public static void main(String[] args) {
        String exampleCronString = "*/15 0 1,15 * 1-5";
        String timestamp = "2024-03-14T00:00:00Z";

        CronStringParser csp = new CronStringParser();
        Cron c = csp.parse(exampleCronString);
        System.out.println(c);

        System.out.println(new Timestamp(timestamp));
    }
}
