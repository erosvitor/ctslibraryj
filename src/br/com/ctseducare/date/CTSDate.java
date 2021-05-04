/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.date;

import br.com.ctseducare.validation.CTSValidation;

/**
 * The CTSDate class provide resources to manipulate dates.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSDate {

  private CTSDate() {

  }

  /**
   * Return the day of date.
   *
   * @param date Date to extract the day
   * @return The day of date
   */
  public static int getDay(String date) {
    if (date == null || !CTSValidation.dateIsValid(date)) {
      return 0;
    } else {
      return Integer.parseInt(date.substring(0, 2));
    }
  }

  /**
   * Return the month of date.
   *
   * @param date Date to extract the month
   * @return The month of date
   */
  public static int getMonth(String date) {
    if (date == null || !CTSValidation.dateIsValid(date)) {
      return 0;
    } else {
      return Integer.parseInt(date.substring(3, 5));
    }
  }

  /**
   * Return the year of date.
   *
   * @param date Date to extract the year
   * @return The year of date
   */
  public static int getYear(String date) {
    if (date == null || !CTSValidation.dateIsValid(date)) {
      return 0;
    } else {
      return Integer.parseInt(date.substring(6, 10));
    }
  }

}
