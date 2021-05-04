/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso;

import br.com.ctseducare.date.CTSDate;
import br.com.ctseducare.validation.CTSValidation;

/**
 * A classe CTSExtensoData fornece recursos para converter uma
 * data, ou partes de uma data, em uma representação por extenso.
 *
 * Por exemplo, a data 10/10/2010 é convertida para 10 de outubro de 2010.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSExtensoData {

  private static final String DIAS_SEMANA[] = {"segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domingo"};

  private static final String DIAS_SEMANA_LONGO[] = {"segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado", "domingo"};

  private static final String MESES[] = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};

  private CTSExtensoData() {

  }

  /**
   * Retornar o nome do dia da semana.
   *
   * @param dia Número do dia da semana
   * @return O nome do dia da semana
   */
  public static String nomeDoDiaDaSemana(int dia) {
    if (dia < 1 || dia > 7) {
      return "dia semana inválido";
    } else {
      return DIAS_SEMANA[dia-1];
    }
  }

  /**
   * Retornar o nome completo do dia da semana.
   *
   * @param dia Número do dia da semana
   * @return O nome completo do dia da semana
   */
  public static String nomeDoDiaDaSemanaCompleto(int dia) {
    if (dia < 1 || dia > 7) {
      return "dia semana inválido";
    } else {
      return DIAS_SEMANA_LONGO[dia-1];
    }
  }

  /**
   * Retornar o nome do mês.
   *
   * @param mes Número do mês
   * @return O nome do mês
   */
  public static String nomeDoMes(int mes) {
    if (mes < 1 || mes > 12) {
      return "mês inválido";
    } else {
      return MESES[mes-1];
    }
  }

  /**
   * Retornar o nome do mês.
   *
   * @param data Data para extrair o número do mês
   * @return O nome do mês
   */
  public static String nomeDoMes(String data) {
    if (data == null || !CTSValidation.dateIsValid(data)) {
      return "mês inválido";
    } else {
      return nomeDoMes(CTSDate.getMonth(data));
    }
  }

  /**
   * Retornar a data por extenso.
   *
   * @param data Data para gerar a data por extenso
   * @return A data por extenso
   */
  public static String dataPorExtenso(String data) {
    if (data == null || !CTSValidation.dateIsValid(data)) {
      return "data inválida";
    } else {
      return CTSDate.getDay(data) + " de " + nomeDoMes(data) + " de " + CTSDate.getYear(data);
    }
  }

}
