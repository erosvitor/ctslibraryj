/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The CTSHashGenerator class provide resources to generate hashs of values of type string.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
public class CTSHashGenerator {
  
  private CTSHashGenerator() {
    
  }

  /**
   * Generate MD5 Hash.
   *
   * @param value Value of string type
   * @return The MD5 hash of the value
   */
  public static String md5(String value) {
    return hexaToString(gerarHash(value, "MD5"));
  }

  /**
   * Generate SHA-1 Hash.
   *
   * @param value Value of string type
   * @return The SHA-1 hash of the value
   */
  public static String sha1(String value) {
    return hexaToString(gerarHash(value, "SHA-1"));
  }

  /**
   * Generate SHA-256 Hash.
   *
   * @param value Value of string type
   * @return The SHA-256 hash of the value
   */
  public static String sha256(String value) {
    return hexaToString(gerarHash(value, "SHA-256"));
  }

  private static byte[] gerarHash(String frase, String algoritmo) {
    try {
      MessageDigest md = MessageDigest.getInstance(algoritmo);
      md.update(frase.getBytes());
      return md.digest();
    } catch (NoSuchAlgorithmException e) {
      return null;
    } 
  }

  private static String hexaToString(byte[] bytes) {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < bytes.length; i++) {
      int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
      int parteBaixa = bytes[i] & 0xf;
      if (parteAlta == 0) {
        s.append('0');
      }  
      s.append(Integer.toHexString(parteAlta | parteBaixa));
    }
    return s.toString();
  }

}