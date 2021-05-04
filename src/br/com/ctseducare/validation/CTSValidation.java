/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.validation;

import br.com.ctseducare.date.CTSDate;

/**
 * The CTSValidation class provide resources to validate names,
 * emails, dates, telephones numbers, zip codes and much others.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSValidation {

  private static final String PATTERN_PERSONAL_NAME = "^[a-zA-ZáàâãéèêíïóôõöúçÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇ ]+$";
  private static final String PATTERN_EMAIL = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}$";
  private static final String PATTERN_DATE_BRAZIL = "^([\\d]|[0-2][\\d]|3[0-1])\\/([\\d]|0[\\d]|1[0-2])\\/\\d{4}$";

  private CTSValidation() {

  }

  /**
   * Checks if a personal name is valid.
   *
   * @param name Personal name
   * @return The value 'true' for a valid name or 'false' otherwise
   */
  public static boolean personalNameIsValid(String name) {
    return name != null && name.matches(PATTERN_PERSONAL_NAME);
  }

  /**
   * Checks if an email is valid.
   *
   * @param email Email
   * @return The value 'true' for a valid email or 'false' otherwise
   */
  public static boolean emailIsValid(String email) {
    return email != null && email.matches(PATTERN_EMAIL);
  }

  /**
   * Checks if a date is valid.
   *
   * @param date Date
   * @return The value 'true' for a valid date or 'false' otherwise
   */
  public static boolean dateIsValid(String date) {
    return date != null && date.matches(PATTERN_DATE_BRAZIL);
  }

  /**
   * Checks if a year is leap year.
   *
   * @param date Date
   * @return The value 'true' for a leap year or 'false' otherwise
  */
  public static boolean isLeapYear(String date) {
    int year = CTSDate.getYear(date);

    return (((year % 4) == 0) && (((year % 400) == 0) || ((year % 100) != 0)));
  }

  /**
   * Checks if a CPF is valid.
   *
   * @param cpf CPF
   * @return The value 'true' for a valid CPF or 'false' otherwise
   */
  public static boolean cpfIsValid(String cpf) {
    if (cpf == null || cpf.trim().length() != 11) {
      return false;
    }

    if (cpf.equals("00000000000") ||
        cpf.equals("11111111111") ||
        cpf.equals("22222222222") ||
        cpf.equals("33333333333") ||
        cpf.equals("44444444444") ||
        cpf.equals("55555555555") ||
        cpf.equals("66666666666") ||
        cpf.equals("77777777777") ||
        cpf.equals("88888888888") ||
        cpf.equals("99999999999")) {
      return false;
    }

    int[] pesos = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
    int i = 0;
    int soma = 0;
    int resto = 0;
    int digito = 0;

    // Calcula e valida o primeiro digito verificador
    for (i = 0; i < 9; i++) {
      soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * pesos[i + 1];
    }
    resto = soma % 11;
    digito = 11 - resto;
    if (digito == 11 || digito == 10) {
      digito = 0;
    }
    if (digito != Integer.parseInt(String.valueOf(cpf.charAt(9)))) {
      return false;
    }

    // Calcula e valida o segundo digito verificador
    soma = 0;
    for (i = 0; i < 10; i++) {
      soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * pesos[i];
    }
    resto = soma % 11;
    digito = 11 - resto;
    if (digito == 11 || digito == 10) {
      digito = 0;
    }

    if (digito != Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Checks if a CNPJ is valid.
   *
   * @param cnpj CNPJ
   * @return The value 'true' for a valid CNPJ or 'false' otherwise
   */
  public static boolean cnpjIsValid(String cnpj) {
    if (cnpj == null || cnpj.trim().length() != 14) {
      return false;
    }

    if (cnpj.equals("00000000000000") ||
        cnpj.equals("11111111111111") ||
        cnpj.equals("22222222222222") ||
        cnpj.equals("33333333333333") ||
        cnpj.equals("44444444444444") ||
        cnpj.equals("55555555555555") ||
        cnpj.equals("66666666666666") ||
        cnpj.equals("77777777777777") ||
        cnpj.equals("88888888888888") ||
        cnpj.equals("99999999999999")) {
      return false;
    }

    int[] pesos = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
    int i = 0;
    int soma = 0;
    int resto = 0;
    int digito = 0;

    // Calcula e valida o primeiro digito verificador
    for (i = 0; i < 12; i++) {
      soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * pesos[i + 1];
    }
    resto = soma % 11;
    digito = 11 - resto;
    if (digito == 11 || digito == 10) {
      digito = 0;
    }
    if (digito != Integer.parseInt(String.valueOf(cnpj.charAt(12)))) {
      return false;
    }

    // Calcula e valida o segundo digito verificador
    soma = 0;
    for (i = 0; i < 13; i++) {
      soma += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * pesos[i];
    }
    resto = soma % 11;
    digito = 11 - resto;
    if (digito == 11 || digito == 10) {
      digito = 0;
    }
    if (digito != Integer.parseInt(String.valueOf(cnpj.charAt(13)))) {
      return false;
    } else {
      return true;
    }
  }

}
