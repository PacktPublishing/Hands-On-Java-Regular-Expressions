package com.tomekl007.chapter_4;

import org.junit.Test;

import java.util.regex.Pattern;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PatternCaseAndCannonTest {
  @Test
  public void givenRegexWithoutCanonEq_whenMatchFailsOnEquivalentUnicode_thenShouldMatch() {
    int matches = runTest("\u00E9", "\u0065\u0301");
    assertFalse(matches > 0);
  }

  @Test
  public void givenRegexWithCanonEq_whenMatchesOnEquivalentUnicode_thenShouldMatch() {
    int matches = runTest("\u00E9", "\u0065\u0301", Pattern.CANON_EQ);
    assertTrue(matches > 0);
  }

  @Test
  public void givenRegexWithDefaultMatcher_whenMatchFailsOnDifferentCases_thenShouldNotMatch() {
    int matches = runTest("cat", "This is a Cat");
    assertFalse(matches > 0);
  }

  @Test
  public void givenRegexWithCaseInsensitiveMatcher_whenMatchesOnDifferentCases_thenShouldMatch() {
    int matches = runTest("cat", "This is a Cat", Pattern.CASE_INSENSITIVE);
    assertTrue(matches > 0);
  }

  @Test
  public void givenRegexWithEmbeddedCaseInsensitiveMatcher_whenMatchesOnDifferentCases_thenShouldMatch() {
    int matches = runTest("(?i)cat", "This is a Cat");
    assertTrue(matches > 0);
  }
}
