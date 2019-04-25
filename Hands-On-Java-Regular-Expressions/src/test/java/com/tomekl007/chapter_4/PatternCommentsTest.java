package com.tomekl007.chapter_4;

import org.junit.Test;

import java.util.regex.Pattern;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertTrue;

public class PatternCommentsTest {

  @Test
  public void givenRegexWithComments_whenMatchesWithFlag_thenShouldMatch() {
    int matches = runTest("dog$  #some comment that will not be interpreted", "This is a dog", Pattern.COMMENTS);
    assertTrue(matches > 0);
  }

  @Test
  public void givenRegexWithComments_whenMatchesWithEmbeddedFlag_thenShouldMatch() {
    int matches = runTest("(?x)dog$  #some comment that will not be interpreted", "This is a dog");
    assertTrue(matches > 0);
  }

}
