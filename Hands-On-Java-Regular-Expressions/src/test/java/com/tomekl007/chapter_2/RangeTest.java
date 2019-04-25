package com.tomekl007.chapter_2;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RangeTest {


  @Test
  public void givenUpperCaseRange_whenMatchesUpperCase_thenFindTwo() {
    int matches = runTest("[A-Z]", "Two Uppercase alphabets 34 overall");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }

  @Test
  public void givenLowerCaseRange_whenMatchesLowerCase_thenCorrect() {
    int matches = runTest("[a-z]", "Two Uppercase alphabets 34 overall");
    assertTrue(matches > 0);
    assertEquals(matches, 26);
  }

  @Test
  public void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenFindAll() {
    int matches = runTest("[a-zA-Z]", "Two Uppercase alphabets 34 overall");
    assertTrue(matches > 0);
    assertEquals(matches, 28);
  }

  @Test
  public void givenNumberRange_whenMatchesAccurately_thenFindTwo() {
    int matches = runTest("[1-5]", "Two Uppercase alphabets 34 overall");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }

  @Test
  public void givenNumberRange_whenMatchesAccurately_thenFindActualNumber() {
    int matches = runTest("[30-35]", "Two Uppercase alphabets 34 overall");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }
}
