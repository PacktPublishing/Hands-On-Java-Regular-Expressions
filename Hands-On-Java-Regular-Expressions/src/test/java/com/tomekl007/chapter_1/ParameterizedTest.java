package com.tomekl007.chapter_1;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;


@RunWith(DataProviderRunner.class)
public class ParameterizedTest {

  @UseDataProvider("regExpTestProvider")
  @Test
  public void givenText_whenSimpleRegexMatchesTwice_thenCorrect(
      String stringPattern, String stringMatcher, int expected
  ) {
    Pattern pattern = Pattern.compile(stringPattern);
    Matcher matcher = pattern.matcher(stringMatcher);
    int matches = 0;
    while (matcher.find()) {
      matches++;
    }

    assertEquals(matches, expected);
  }


  @DataProvider
  public static Object[][] regExpTestProvider() {
    return new Object[][]{
        {"find-this", "find-this and something else", 1},
        {"find-this", "no match", 0},
        {"find-this", "find-this and else and find-this", 2}
    };
  }
}
