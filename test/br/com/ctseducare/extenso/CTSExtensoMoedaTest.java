/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CTSExtensoMoedaTest {

  @Test
  public void valorPorExtensoValidoNumeroInteiro() {
    assertEquals("dez reais", CTSExtensoMoeda.valorPorExtenso("10"));
  }

  @Test
  public void valorPorExtensoValidoNumeroFracionario() {
    assertEquals("dez reais", CTSExtensoMoeda.valorPorExtenso("10.00"));
  }

  @Test
  public void valorPorExtensoValidoNumeroFracionarioGrande() {
    assertEquals("um mil setecentos e cinquenta reais e quarenta centavos", CTSExtensoMoeda.valorPorExtenso("1750.40"));
  }

  @Test
  public void valorPorExtensoInvalidoValorNull() {
    assertEquals("valor inválido", CTSExtensoMoeda.valorPorExtenso(null));
  }

  @Test
  public void valorPorExtensoInvalidoValorVazio() {
    assertEquals("valor inválido", CTSExtensoMoeda.valorPorExtenso(""));
  }

}
