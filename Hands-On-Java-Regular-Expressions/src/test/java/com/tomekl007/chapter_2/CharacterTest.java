package com.tomekl007.chapter_2;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterTest {
  @Test
  public void givenDigitsCharacter_whenMatchThreeNumbers_thenShouldFindMatch() {
    int matches = runTest("\\d", "123");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }

  @Test
  public void givenNotDigitsCharacter_whenMatchTwoLetters_thenShouldFindMatch() {
    int matches = runTest("\\D", "a6c");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }

  @Test
  public void givenWhitespaceCharacter_whenMatchOneSpace_thenShouldFindMatch() {
    int matches = runTest("\\s", "a c");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

  @Test
  public void givenNotWhitespaceCharacter_whenMatchTwoLetters_thenShouldFindBothMatches() {
    int matches = runTest("\\S", "a c");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }

  @Test
  public void givenWordCharacter_whenMatchesWords_theShouldMatchBoth() {
    int matches = runTest("\\w", "hi!");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }

  @Test
  public void givenNonWordCharacter_whenMatchesMark_thenShouldMatchNotWords() {
    int matches = runTest("\\W", "hi!");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

}
