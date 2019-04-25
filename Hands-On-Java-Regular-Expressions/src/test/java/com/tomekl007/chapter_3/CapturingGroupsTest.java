package com.tomekl007.chapter_3;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CapturingGroupsTest {

  @Test
  public void givenCapturingGroup_whenMatchesOneOccurrence_thenSuccess() {
    int matches = runTest("(\\d\\d)", "12");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

  @Test
  public void givenCapturingGroup_whenMatchesTwoOccurrences_thenSuccess() {
    int matches = runTest("(\\d\\d)", "1212");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }


}
