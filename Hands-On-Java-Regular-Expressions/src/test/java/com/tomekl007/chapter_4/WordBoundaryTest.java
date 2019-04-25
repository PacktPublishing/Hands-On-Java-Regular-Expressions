package com.tomekl007.chapter_4;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBoundaryTest {
  @Test
  public void givenText_whenMatchesAtWordBoundary_thenShouldMatch() {
    int matches = runTest("\\bcat\\b", "a cat at the boundary");
    assertTrue(matches > 0);
  }

  @Test
  public void givenText_whenMatchesAtWordBoundary_thenShouldMatch2() {
    int matches = runTest("\\bcat\\b", "cat that match the boundary");
    assertTrue(matches > 0);
  }

  @Test
  public void givenWrongText_whenMatchFailsAtWordBoundary_thenShouldNotMatch() {
    int matches = runTest("\\bcat\\b", "there is catt with a typo");
    assertFalse(matches > 0);
  }

  @Test
  public void givenText_whenMatchesAtWordAndNonBoundary_thenShouldMatch() {
    int matches = runTest("\\bcat\\B", "there is catt with a typo");
    assertTrue(matches > 0);
  }
}
