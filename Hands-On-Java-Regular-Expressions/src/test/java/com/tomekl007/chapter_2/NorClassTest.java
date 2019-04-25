package com.tomekl007.chapter_2;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NorClassTest {
  @Test
  public void givenNORSet_whenMatchesNon_thenFindMatch() {
    int matches = runTest("[^abc]", "g");
    assertTrue(matches > 0);
    assertEquals(1, matches);
  }

  @Test
  public void givenNORSet_whenMatchesAllExceptElements_thenFindThreeMatches() {
    int matches = runTest("[^bcr]at", "sat mat eat");
    assertTrue(matches > 0);
    assertEquals(3, matches);
  }
}
