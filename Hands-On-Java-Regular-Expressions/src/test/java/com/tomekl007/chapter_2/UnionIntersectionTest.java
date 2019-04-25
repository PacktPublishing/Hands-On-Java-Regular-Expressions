package com.tomekl007.chapter_2;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnionIntersectionTest {

  @Test
  public void givenTwoSets_whenMatchesUnion_thenFindSixNumbers() {
    int matches = runTest("[1-3[7-9]]", "123456789");
    assertTrue(matches > 0);
    assertEquals(matches, 6);
  }

  @Test
  public void givenTwoSets_whenMatchesIntersection_thenFindIntersect() {
    int matches = runTest("[1-6&&[3-9]]", "123456789");
    assertTrue(matches > 0);
    assertEquals(matches, 4);
  }


  @Test
  public void givenSetWithSubtraction_whenMatchesAccurately_thenFindAllBeisdesNot() {
    int matches = runTest("[0-9&&[^2468]]", "123456789");
    assertTrue(matches > 0);
    assertEquals(matches, 5);
  }

}
