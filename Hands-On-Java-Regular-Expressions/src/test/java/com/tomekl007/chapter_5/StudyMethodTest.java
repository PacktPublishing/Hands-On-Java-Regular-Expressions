package com.tomekl007.chapter_5;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudyMethodTest {
  @Test
  public void givenSentence_whenUsingStudy_thenLookingAtShouldReturnTrue() {
    Pattern pattern = Pattern.compile("dog");
    Matcher matcher = pattern.matcher("dogs are friendly");
    assertTrue(matcher.lookingAt());
    assertFalse(matcher.matches());

  }

  @Test
  public void givenSentence_whenUsingMatcherThatMatch_thenMatchersShouldReturnTrue() {
    Pattern pattern = Pattern.compile("dog");
    Matcher matcher = pattern.matcher("dog");
    assertTrue(matcher.matches());

  }

}
