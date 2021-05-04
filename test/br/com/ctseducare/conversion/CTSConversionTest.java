/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.conversion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CTSConversionTest {

  @Test
  public void testSecondsToHours() {
    assertEquals("01:00:00", CTSConversion.secondsToHours(3600));
  }

  @Test
  public void testHoursToSeconds() {
    assertEquals(3600, CTSConversion.hoursToSeconds("01:00:00"));
  }

}
