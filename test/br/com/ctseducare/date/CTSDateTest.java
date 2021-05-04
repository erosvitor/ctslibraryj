/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CTSDateTest {

  @Test
  public void testGetDayValid() {
    assertEquals(10, CTSDate.getDay("10/10/2010"));
  }

  @Test
  public void testGetMonthValid() {
    assertEquals(10, CTSDate.getMonth("10/10/2010"));
  }

  @Test
  public void testGetYearValid() {
    assertEquals(2010, CTSDate.getYear("10/10/2010"));
  }

}
