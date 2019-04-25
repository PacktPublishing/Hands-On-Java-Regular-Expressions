package com.tomekl007.chapter_3;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RepeatingMultipleTimesTest {

  @Test
  public void givenCapturingGroup_whenMatches_thenMatchMultipleSequences() {
    int matches = runTest("(\\d\\d)(\\d\\d)", "1212");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }
  //next video we will improve it using back-reference
}
