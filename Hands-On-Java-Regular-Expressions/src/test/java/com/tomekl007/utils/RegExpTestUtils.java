package com.tomekl007.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTestUtils {

  public static int runTest(String regex, String text) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    int matches = 0;
    while (matcher.find())
      matches++;
    return matches;
  }

  public static int runTest(String regex, String text, int flags) {
    Pattern pattern = Pattern.compile(regex, flags);
    Matcher matcher = pattern.matcher(text);
    int matches = 0;
    while (matcher.find())
      matches++;
    return matches;
  }
}
