/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CTSExtensoDataTest {

  //--------------------------------------------------------------------------------
  // Testes para validar dia da semana por extenso
  //--------------------------------------------------------------------------------
  @Test
  public void testDiaSemanaValido() {
    assertEquals("segunda", CTSExtensoData.nomeDoDiaDaSemana(1));
  }

  @Test
  public void testDiaSemanaInvalido() {
    assertEquals("dia semana inválido", CTSExtensoData.nomeDoDiaDaSemana(8));
  }

  @Test
  public void testDiaSemanaCompletoValido() {
    assertEquals("segunda-feira", CTSExtensoData.nomeDoDiaDaSemanaCompleto(1));
  }

  @Test
  public void testDiaSemanaCompletoInvalido() {
    assertEquals("dia semana inválido", CTSExtensoData.nomeDoDiaDaSemana(8));
  }

  //--------------------------------------------------------------------------------
  // Testes para validar dia do mês por extenso
  //--------------------------------------------------------------------------------
  @Test
  public void testMesPorExtensoValido() {
    assertEquals("outubro", CTSExtensoData.nomeDoMes(10));
  }

  @Test
  public void testMesPorExtensoInvalido() {
    assertEquals("mês inválido", CTSExtensoData.nomeDoMes(0));
  }

  @Test
  public void testMesPorExtensoValidoPorData() {
    assertEquals("outubro", CTSExtensoData.nomeDoMes("10/10/2010"));
  }

  @Test
  public void testMesPorExtensoInvalidoPorData() {
    assertEquals("mês inválido", CTSExtensoData.nomeDoMes("10/20/2010"));
  }

  @Test
  public void testMesPorExtensoInvalidoPorDataIncompleta() {
    assertEquals("mês inválido", CTSExtensoData.nomeDoMes("10/10/20"));
  }

  @Test
  public void testMesPorExtensoInvalidoPorDataNull() {
    assertEquals("mês inválido", CTSExtensoData.nomeDoMes(null));
  }

  //--------------------------------------------------------------------------------
  // Testes para validar data por extenso
  //--------------------------------------------------------------------------------
  @Test
  public void testDataPorExtensoDataValida() {
    assertEquals("10 de outubro de 2010", CTSExtensoData.dataPorExtenso("10/10/2010"));
  }

  @Test
  public void testDataPorExtensoDataInvalida() {
    assertEquals("data inválida", CTSExtensoData.dataPorExtenso("10/20/2010"));
  }

  @Test
  public void testDataPorExtensoDataIncompleta() {
    assertEquals("data inválida", CTSExtensoData.dataPorExtenso("10/20/20"));
  }

  @Test
  public void testDataPorExtensoDataNull() {
    assertEquals("data inválida", CTSExtensoData.dataPorExtenso(null));
  }

  @Test
  public void testDataPorExtensoDataVazia() {
    assertEquals("data inválida", CTSExtensoData.dataPorExtenso(""));
  }

}
