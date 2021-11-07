package com.example.auctionshortenedurl.core;

public class UrlUtil {

  public static boolean isValid(String longUrl) {

    org.apache.commons.validator.routines.UrlValidator
        urlValidator = new org.apache.commons.validator.routines.UrlValidator(
        new String[] {"http", "https"}
    );

    return urlValidator.isValid(longUrl);
  }
}
