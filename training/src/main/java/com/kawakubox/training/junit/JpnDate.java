package com.kawakubox.training.junit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kawakubox on 2015/02/13.
 */
public class JpnDate {

    private static final String MEIJI_START = "18680125";
    private static final String TAISHO_START = "19120730";
    private static final String SHOWA_START = "19261225";
    private static final String HEISEI_START = "19890108";

    private Date date;

    public JpnDate() {
        this.date = new Date();
    }

    public JpnDate(String ymd) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = df.parse(ymd);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String getJpnEra() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String targetYmd = df.format(date);

        if (MEIJI_START.compareTo(targetYmd) > 0) {
            return "undefined";
        } else if (MEIJI_START.compareTo(targetYmd) <= 0 && TAISHO_START.compareTo(targetYmd) > 0) {
            return "明治";
        } else if (TAISHO_START.compareTo(targetYmd) <= 0 && SHOWA_START.compareTo(targetYmd) > 0) {
            return "大正";
        } else if (SHOWA_START.compareTo(targetYmd) <= 0 && HEISEI_START.compareTo(targetYmd) > 0) {
            return "昭和";
        } else {
            return "平成";
        }
    }

}
