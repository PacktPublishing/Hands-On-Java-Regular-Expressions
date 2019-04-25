package com.tomekl007.chapter_3;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackReferenceTest {

  @Test
  public void givenCapturingGroup_whenMatchesWithBackReference_thenMatchRepeatingSequence() {
    int matches = runTest("(\\d\\d)\\1", "1212");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

  @Test
  public void givenCapturingGroup_whenMatchesWithBackReference_thenMatchMultipleRepeatingSequences() {
    int matches = runTest("(\\d\\d)\\1\\1\\1", "12121212");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

  @Test
  public void givenCapturingGroupAndWrongInput_whenMatchFailsWithBackReference_thenMatchSequencesOfNumbers() {
    int matches = runTest("(\\d\\d)\\1", "1213");
    assertFalse(matches > 0);
  }
}
