package com.tomekl007.chapter_3;

import org.junit.Test;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuantifierTest {

  @Test
  public void givenZeroOrOneQuantifier_whenMatches_thenShouldMatch() {
    int matches = runTest("\\a?", "hi");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }

  @Test
  public void givenZeroOrOneQuantifierWithQuantity_whenMatches_thenShouldMatch() {
    int matches = runTest("\\a{0,1}", "hi");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }

  @Test
  public void givenZeroOrManyQuantifier_whenMatches_thenShouldMatch() {
    int matches = runTest("\\a*", "hi");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }

  @Test
  public void givenZeroOrManyQuantifier_whenMatches_thenShouldMatch2() {
    int matches = runTest("\\a{0,}", "hi");
    assertTrue(matches > 0);
    assertEquals(matches, 3);
  }

  @Test
  public void givenOneOrManyQuantifier_whenMatches_thenShouldMatch() {
    int matches = runTest("\\a+", "hi");
    assertFalse(matches > 0);
  }

  @Test
  public void givenOneOrManyQuantifier_whenMatches_thenShouldMatch2() {
    int matches = runTest("\\a{1,}", "hi");
    assertFalse(matches > 0);
  }

  @Test
  public void givenBraceQuantifier_whenMatches_thenShouldMatch() {
    int matches = runTest("a{3}", "aaaaaa");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }

  @Test
  public void givenBraceQuantifier_whenFailsToMatch_thenShouldMatch() {
    int matches = runTest("a{3}", "aa");
    assertFalse(matches > 0);
  }

  @Test
  public void givenBraceQuantifierWithRange_whenMatches_thenShouldMatch() {
    int matches = runTest("a{2,3}", "aaaa");
    assertTrue(matches > 0);
    assertEquals(matches, 1);
  }

  @Test
  public void givenBraceQuantifierWithRange_whenMatchesLazily_thenShouldMatch() {
    int matches = runTest("a{2,3}?", "aaaa");
    assertTrue(matches > 0);
    assertEquals(matches, 2);
  }
}
