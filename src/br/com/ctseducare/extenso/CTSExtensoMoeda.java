/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.extenso;

import java.util.ArrayList;

/**
 * A classe CTSExtensoMoeda fornece recursos para converter um
 * valor monetário por extenso.
 *
 * Por exemplo, o valor 1.500,00 é convertido para Um mil e quinhentos reais.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSExtensoMoeda {
  private static final int SINGULAR = 0;
  private static final int PLURAL = 1;

  private static String[] unidades = { "", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
      "dez", "onze", "doze", "treze", "quatorze", "quinze", "dessesseis", "dezessete", "dezoito", "dezenove" };
  private static String[] dezenas = { "", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta",
      "oitenta", "noventa" };
  private static String[] centenas = { "", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos",
      "setecentos", "oitocentos", "novecentos" };
  private static String[][] milhares = { { "", "" }, { "", "" }, { "mil", "mil" }, { "milhão", "milhões" },
      { "bilhão", "bilhões" }, { "trilhão", "trilhões" } };

  private CTSExtensoMoeda() {

  }

  /**
   * Retornar o valor monetário por extenso.
   *
   * @param valor Valor monetário a ser convertido em extenso
   * @return O extenso do valor monetário
   */
  public static String valorPorExtenso(String valor) {
    if (valor == null || valor.trim().isEmpty()) {
      return "valor inválido";
    }

    int posVirgula;
    String casasDecimais;
    String numeroTmp;
    ArrayList<String> centenas = new ArrayList<String>();
    String inteiroPorExtenso = "";
    String decimalPorExtenso = "";

    // --------------------------------------------------------------------------------
    // Calcula o extenso da parte decimal, se houver.
    posVirgula = valor.indexOf('.');
    if (posVirgula > 0) {
      casasDecimais = valor.substring(posVirgula + 1);
      decimalPorExtenso = centenaPorExtenso(Integer.parseInt(casasDecimais));
      if (Integer.parseInt(casasDecimais) == 0)
        decimalPorExtenso = "";
      else if (Integer.parseInt(casasDecimais) == 1)
        decimalPorExtenso += " centavo";
      else
        decimalPorExtenso += " centavos";
      numeroTmp = valor.substring(0, posVirgula);
    } else
      numeroTmp = valor;

    // --------------------------------------------------------------------------------
    // Calcula o extenso da parte inteira.
    // Verifica quantas centenas cheias existem (Ex. O número 1500300 tem duas centenas cheias)
    int totalCentenasCheias = numeroTmp.length() / 3;

    // Verifica as posições para pegar a centena incompleta, se
    // houver (Ex. O número 1500300 tem como centena incompleta o 1)
    int posicaoInicial = 0;
    int posicaoFinal = numeroTmp.length() - (totalCentenasCheias * 3);

    // Cria variável para guardar o índice das medidas...
    int indiceMilhar;

    // Verifica se existe centena incompleta...
    if (posicaoInicial != posicaoFinal) {
      // Havendo centena incompleta, pega ela e adiciona na lista de centenas...
      centenas.add(numeroTmp.substring(posicaoInicial, posicaoFinal));
      indiceMilhar = totalCentenasCheias + 1;
    } else
      indiceMilhar = totalCentenasCheias;

    // Pega as posições da primeira centena cheia...
    posicaoInicial += posicaoFinal;
    posicaoFinal += 3;

    // Adiciona a centena cheia na lista e busco as demais centenas, se houverem...
    for (int i = 1; i <= totalCentenasCheias; i++) {
      centenas.add(numeroTmp.substring(posicaoInicial, posicaoFinal));
      posicaoInicial += 3;
      posicaoFinal += 3;
    }

    // Calcula o extenso de cada centena...
    int indiceColuna;
    for (int i = 0; i < centenas.size(); i++) {
      if (!centenas.get(i).equals("000")) {
        indiceColuna = (Integer.parseInt(centenas.get(i)) == 1 ? SINGULAR : PLURAL);
        inteiroPorExtenso += " " + centenaPorExtenso(Integer.parseInt(centenas.get(i))) + " "
            + milhares[indiceMilhar][indiceColuna];
      }
      indiceMilhar--;
    }

    if ((totalCentenasCheias == 0) && (centenas.get(0).equals("1")))
      inteiroPorExtenso = inteiroPorExtenso.trim() + " real";
    else
      inteiroPorExtenso = inteiroPorExtenso.trim() + " reais";

    if (decimalPorExtenso.equals(""))
      return inteiroPorExtenso;
    else
      return inteiroPorExtenso + " e " + decimalPorExtenso;
  }

  /**
   * Retorna a centena por extenso.
   *
   * @param numero Número representando a centena
   * @return A centena por extenso
   */
  private static String centenaPorExtenso(int numero) {
    String numeroString = String.valueOf(numero);

    if (numero < 20) {
      return unidades[numero];
    } else if (numero < 100) {
      int dezena = Integer.parseInt(numeroString.substring(0, 1));
      int unidade = Integer.parseInt(numeroString.substring(1, 2));
      return dezenas[dezena] + (unidade == 0 ? "" : " e " + unidades[unidade]);
    } else if (numero < 1000) {
      int centena = Integer.parseInt(numeroString.substring(0, 1));
      int dezena = Integer.parseInt(numeroString.substring(1, 2));
      int unidade = Integer.parseInt(numeroString.substring(2, 3));
      if ((centena == 1) && ((dezena > 0) || (unidade > 0))) {
        return "cento" + (dezena == 0 ? "" : " e " + dezenas[dezena])
            + (unidade == 0 ? "" : " e " + unidades[unidade]);
      }
      else {
        return centenas[centena] + (dezena == 0 ? "" : " e " + dezenas[dezena])
            + (unidade == 0 ? "" : " e " + unidades[unidade]);
      }
    } else {
      return "";
    }
  }
}
