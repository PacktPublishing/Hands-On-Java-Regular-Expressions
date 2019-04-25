package com.tomekl007.chapter_4;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoundaryMatcherBeginningOfLineTest {
  @Test
  public void givenText_whenMatchesAtBeginning_thenShouldMatch() {
    int matches = runTest("^cat", "cats are friendly");
    assertTrue(matches > 0);
  }

  @Test
  public void givenTextAndWrongInput_whenMatchFailsAtBeginning_thenShouldNotMatch() {
    int matches = runTest("^cat", "are cats are friendly?");
    assertFalse(matches > 0);
  }

  @Test
  public void givenText_whenMatchesAtEnd_thenShouldMatch() {
    int matches = runTest("cat$", "Man's best friend is a cat");
    assertTrue(matches > 0);
  }

  @Test
  public void givenTextAndWrongInput_whenMatchFailsAtEnd_thenShouldNotMatch() {
    int matches = runTest("cat$", "is a cat man's best friend?");
    assertFalse(matches > 0);
  }
}
