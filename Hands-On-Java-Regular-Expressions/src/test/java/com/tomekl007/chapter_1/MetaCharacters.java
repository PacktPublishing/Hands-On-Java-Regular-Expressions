package com.tomekl007.chapter_1;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MetaCharacters {

  @Test
  public void givenText_whenMatchesWithDot_thenShouldMatchAll() {
    int matches = runTest(".", "any-String");
    System.out.println(matches);
    assertTrue(matches > 0);
  }

  @Test
  public void givenRepeatedText_whenMatchesOnceWithDot_theMatchOnce() {
    int matches = runTest("any.", "anyany");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }


  @Test
  public void givenNotRepeatedText_whenMatchesOnceWithDot_theMatchOnce() {
    int matches = runTest("any.", "anyNot");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }
}
