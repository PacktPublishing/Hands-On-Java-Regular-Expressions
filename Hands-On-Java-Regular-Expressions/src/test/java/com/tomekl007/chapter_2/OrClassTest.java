package com.tomekl007.chapter_2;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrClassTest {
  @Test
  public void givenORSet_whenMatchesAny_thenCorrect() {
    int matches = runTest("[abc]", "b");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

  @Test
  public void givenORSet_whenMatchesAnyAndAll_thenThreeCorrect() {
    int matches = runTest("[abc]", "cab");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }

  @Test
  public void givenORSet_whenMatchesAllCombinations_thenThreeCorrect() {
    int matches = runTest("[bcr]at", "bat cat rat");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }
}
