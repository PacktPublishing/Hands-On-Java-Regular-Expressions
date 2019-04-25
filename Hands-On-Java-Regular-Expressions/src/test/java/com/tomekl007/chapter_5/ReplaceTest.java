package com.tomekl007.chapter_5;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class ReplaceTest {
  @Test
  public void givenSentence_whenUsingReplaceFirst_thenShouldReplaceFirstOccurrence() {
    Pattern pattern = Pattern.compile("dog");
    Matcher matcher = pattern.matcher("dogs are domestic animals, dogs are friendly");
    String newStr = matcher.replaceFirst("cat");
    assertEquals("cats are domestic animals, dogs are friendly", newStr);

  }

  @Test
  public void givenSentence_whenUsingReplaceAll_thenShouldReplaceAllOccurrences() {
    Pattern pattern = Pattern.compile("dog");
    Matcher matcher = pattern.matcher("dogs are domestic animals, dogs are friendly");
    String newStr = matcher.replaceAll("cat");
    assertEquals("cats are domestic animals, cats are friendly", newStr);

  }
}
