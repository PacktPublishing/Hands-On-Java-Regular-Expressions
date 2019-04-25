package com.tomekl007.chapter_1;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class StringLiterals {
  @Test
  public void givenText_whenSimpleRegex_thenShouldMatchesTwice() {
    Pattern pattern = Pattern.compile("some string");
    Matcher matcher = pattern.matcher("some string some string");
    int matches = 0;
    while (matcher.find()) {
      matches++;
    }

    assertEquals(matches, 2);
  }

}
