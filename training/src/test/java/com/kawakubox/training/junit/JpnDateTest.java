package com.kawakubox.training.junit;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class JpnDateTest {

    @Test
    public void getJpnEra_明治以前から明治の境界() throws Exception {
        JpnDate jpnDate = new JpnDate("1868-01-25");
        assertThat(jpnDate.getJpnEra(), is("明治"));

        jpnDate = new JpnDate("1868-01-24");
        assertThat(jpnDate.getJpnEra(), is("undefined"));
    }

    @Test
    public void getJpnEra_明治から大正の境界() throws Exception {
        JpnDate jpnDate = new JpnDate("1912-07-29");
        assertThat(jpnDate.getJpnEra(), is("明治"));

        jpnDate = new JpnDate("1912-07-30");
        assertThat(jpnDate.getJpnEra(), is("大正"));
    }

    @Test
    public void getJpnEra_大正から昭和の境界() throws Exception {
        JpnDate jpnDate = new JpnDate("1926-12-24");
        assertThat(jpnDate.getJpnEra(), is("大正"));

        jpnDate = new JpnDate("1926-12-25");
        assertThat(jpnDate.getJpnEra(), is("昭和"));
    }

    @Test
    public void getJpnEra_昭和から平成の境界() throws Exception {
        JpnDate jpnDate = new JpnDate("1989-01-07");
        assertThat(jpnDate.getJpnEra(), is("昭和"));

        jpnDate = new JpnDate("1989-01-08");
        assertThat(jpnDate.getJpnEra(), is("平成"));
    }
}