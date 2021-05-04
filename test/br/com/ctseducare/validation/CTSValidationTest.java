/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.validation;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CTSValidationTest {

  //--------------------------------------------------------------------------------
  // Tests for validation of personal name
  //--------------------------------------------------------------------------------
  @Test
  public void testPersonalNameValid() {
    assertTrue(CTSValidation.personalNameIsValid("Eros Vitor"));
  }

  @Test
  public void testPersonalNameInvalid() {
    assertFalse(CTSValidation.personalNameIsValid("Eros 10 Vitor"));
  }

  @Test
  public void testPersonalNameNull() {
    assertFalse(CTSValidation.personalNameIsValid(null));
  }

  @Test
  public void testPersonalNameBlank() {
    assertFalse(CTSValidation.personalNameIsValid(""));
  }

  //--------------------------------------------------------------------------------
  // Tests for validation of email
  //--------------------------------------------------------------------------------
  @Test
  public void testEmailValid() {
    assertTrue(CTSValidation.emailIsValid("email@yahoo.com.br"));
  }

  @Test
  public void testEmailInvalid() {
    assertFalse(CTSValidation.emailIsValid("email@yahoo"));
  }

  @Test
  public void testEmailNull() {
    assertFalse(CTSValidation.emailIsValid(null));
  }

  @Test
  public void testEmailBlank() {
    assertFalse(CTSValidation.emailIsValid(""));
  }

  //--------------------------------------------------------------------------------
  // Tests for validation of date
  //--------------------------------------------------------------------------------
  @Test
  public void testDateValid() {
    assertTrue(CTSValidation.dateIsValid("10/10/2010"));
  }

  @Test
  public void testDateInvalid() {
    assertFalse(CTSValidation.dateIsValid("10/20/2010"));
  }

  @Test
  public void testDateIncomplete() {
    assertFalse(CTSValidation.dateIsValid("10/20/"));
  }

  @Test
  public void testDateNull() {
    assertFalse(CTSValidation.dateIsValid(null));
  }

  @Test
  public void testDateBlank() {
    assertFalse(CTSValidation.dateIsValid(""));
  }

  //--------------------------------------------------------------------------------
  // Tests for leap year
  //--------------------------------------------------------------------------------
  @Test
  public void testYearIsNotLeapYear() {
    assertFalse(CTSValidation.isLeapYear("10/10/2010"));
  }

  @Test
  public void testYearIsLeapYear() {
    assertTrue(CTSValidation.isLeapYear("10/10/2012"));
  }

  //--------------------------------------------------------------------------------
  // Tests for validation of CPF
  //--------------------------------------------------------------------------------
  @Test
  public void testCPFValid() {
    assertTrue(CTSValidation.cpfIsValid("28309200404"));
  }

  @Test
  public void testCPFInvalid() {
    assertFalse(CTSValidation.cpfIsValid("28309200405"));
  }

  @Test
  public void testCPFInvalidCPFRepetedNumbers() {
    assertFalse(CTSValidation.cpfIsValid("11111111111"));
  }

  //--------------------------------------------------------------------------------
  // Tests for validation of CNPJ
  //--------------------------------------------------------------------------------
  @Test
  public void testCNPJValid() {
    assertTrue(CTSValidation.cnpjIsValid("22871777000164"));
  }

  @Test
  public void testCNPJInvalid() {
    assertFalse(CTSValidation.cnpjIsValid("22871777000165"));
  }

  @Test
  public void testCNPJInvalidCNPJRepetedNumbers() {
    assertFalse(CTSValidation.cnpjIsValid("11111111111111"));
  }

}
