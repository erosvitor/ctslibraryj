/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.formatting;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CTSFormattingTest {

  //--------------------------------------------------------------------------------
  // Tests for formatting personal name
  //--------------------------------------------------------------------------------
  @Test
  public void formatCorrectPersonalName() {
    assertEquals("Eros Vitor", CTSFormatting.formatPersonalName("EROS vitor"));
  }

  //--------------------------------------------------------------------------------
  // Tests for formatting CPF
  //--------------------------------------------------------------------------------
  @Test
  public void retirarformatacaoCPFCorreto() {
    assertEquals("01790227925", CTSFormatting.cpfRetirarFormatacao("017.902.279-25"));
  }

  @Test
  public void formatarCPFCorreto() {
    assertEquals("017.902.279-25", CTSFormatting.cpfAplicarFormatacao("017902279-25"));
  }

  //--------------------------------------------------------------------------------
  // Tests for formatting CNPJ
  //--------------------------------------------------------------------------------
  @Test
  public void retirarformatacaoCNPJCorreto() {
    assertEquals("08823013000172", CTSFormatting.cnpjRetirarFormatacao("08.823.013/0001-72"));
  }

  @Test
  public void formatarCNPJCorreto() {
    assertEquals("08.823.013/0001-72", CTSFormatting.cnpjAplicarFormatacao("08823013/0001-72"));
  }

}
