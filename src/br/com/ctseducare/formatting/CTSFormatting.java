/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.formatting;

/**
 * The CTSFormatting class provide resources to format name,
 * document numbers and much others.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSFormatting {

  /**
   * Format personal name.
   *
   * @param name Personal name
   * @return The name formatted
   */
  public static String formatPersonalName(String name) {
    String str = String.valueOf(name.charAt(0)).toUpperCase();
    for (int i=1; i < name.length(); i++) {
      if (name.charAt(i) == ' ') {
        i++;
        str += ' ';
        str += String.valueOf(name.charAt(i)).toUpperCase();
      }
      else {
        str += String.valueOf(name.charAt(i)).toLowerCase();
      }
    }
    return str;
  }

  /**
   * Retira caracteres de formatação do CPF.
   *
   * @param cpf CPF
   * @return O CPF sem formatação
   */
  public static String cpfRetirarFormatacao(String cpf) {
    StringBuilder cpfSemFormatacao = new StringBuilder();

    for (int i=0; i < cpf.length(); i++) {
      if (Character.isDigit(cpf.charAt(i))) {
        cpfSemFormatacao.append(cpf.charAt(i));
      }
    }

    return cpfSemFormatacao.toString();
  }

  /**
   * Formata o CPF.
   *
   * @param cpf CPF
   * @return O CPF formatado
   */
  public static String cpfAplicarFormatacao(String cpf)
  {
    String temp = cpfRetirarFormatacao(cpf);

    if (temp.length() != 11) {
      return cpf;
    } else {
      return temp.substring(0, 3) + "." + temp.substring(3, 6) + "." + temp.substring(6, 9) + "-" + temp.substring(9, 11);
    }
  }

  /**
   * Retira caracteres de formatação do CNPJ.
   *
   * @param cnpj CNPJ
   * @return O CNPJ sem formatação
   */
  public static String cnpjRetirarFormatacao(String cnpj)
  {
    StringBuilder cnpjSemFormatacao = new StringBuilder();

    for (int i=0; i < cnpj.length(); i++) {
      if (Character.isDigit(cnpj.charAt(i))) {
        cnpjSemFormatacao.append(cnpj.charAt(i));
      }
    }

    return cnpjSemFormatacao.toString();
  }

  /**
   * Formata o CNPJ.
   *
   * @param cnpj CNPJ
   * @return O CNPJ formatado
   */
  public static String cnpjAplicarFormatacao(String cnpj)
  {
    String temp = cnpjRetirarFormatacao(cnpj);

    if (temp.length() != 14) {
      return cnpj;
    } else {
      return temp.substring(0, 2) + "." + temp.substring(2, 5) + "." + temp.substring(5, 8) + "/" + temp.substring(8, 12) + "-" + temp.substring(12, 14);
    }
  }

}
