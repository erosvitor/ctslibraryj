/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.conversion;

/**
 * The CTSConversion class provide resources to conversion of values dates and texts.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSConversion {

  private CTSConversion() {

  }

  /**
   * Convert seconds to hours.
   *
   * @param seconds Seconds to be converted for hours
   * @return The seconds converted to hours
   */
  public static String secondsToHours(int seconds) {
    StringBuilder hoursStr = new StringBuilder();
    int minutes = 0;
    int hours = 0;

    minutes = seconds / 60;
    seconds = seconds % 60;
    if (minutes >= 60) {
      hours = minutes / 60;
      minutes = minutes % 60;
    }

    hoursStr.append(hours < 10 ? "0" + hours : hours);
    hoursStr.append(":");
    hoursStr.append(minutes < 10 ? "0" + minutes : minutes);
    hoursStr.append(":");
    hoursStr.append(seconds < 10 ? "0" + seconds : seconds);

    return hoursStr.toString();
  }

  /**
   * Convert hours to seconds.
   *
   * @param hours Hours to be converted for seconds
   * @return The hours converted to seconds
   */
  public static int hoursToSeconds(String hours) {
    String tmp = "";
    int hoursTmp;
    int minutes;
    int seconds;
    int totalSeconds;

    tmp += hours.charAt(0);
    tmp += hours.charAt(1);
    hoursTmp = Integer.parseInt(tmp);

    tmp = "";
    tmp += hours.charAt(3);
    tmp += hours.charAt(4);
    minutes = Integer.parseInt(tmp);

    tmp = "";
    tmp += hours.charAt(6);
    tmp += hours.charAt(7);
    seconds = Integer.parseInt(tmp);

    totalSeconds = seconds + (minutes * 60) + (hoursTmp * 3600);

    return totalSeconds;
  }
  
  /**
   * Convert null string to empty string.
   *
   * @param value Value to be converted for empty if null
   * @return The empty string if value is null
   */
  public static String emptyIfNull(String value) {
    return value == null ? "" : value;
  }

}
