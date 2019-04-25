package com.tomekl007.chapter_4;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tomekl007.utils.RegExpTestUtils.runTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LiteralMultipleTest {
  @Test
  public void givenRegexWithLineTerminator_whenMatchFails_thenShouldMatch() {
    Pattern pattern = Pattern.compile("(.*)");
    Matcher matcher = pattern.matcher("this is a text" + System.getProperty("line.separator") + " continued on another line");
    matcher.find();
    assertEquals("this is a text", matcher.group(1));
  }

  @Test
  public void givenRegexWithLineTerminator_whenMatchesWithDotall_thenShouldMatch() {
    Pattern pattern = Pattern.compile("(.*)", Pattern.DOTALL);
    Matcher matcher = pattern.matcher("this is a text" + System.getProperty("line.separator") + " continued on another line");
    matcher.find();
    assertEquals("this is a text" + System.getProperty("line.separator") + " continued on another line", matcher.group(1));
  }

  @Test
  public void givenRegexWithLineTerminator_whenMatchesWithEmbeddedDotall_thenShouldMatch() {
    Pattern pattern = Pattern.compile("(?s)(.*)");
    Matcher matcher = pattern.matcher("this is a text" + System.getProperty("line.separator") + " continued on another line");
    matcher.find();
    assertEquals("this is a text" + System.getProperty("line.separator") + " continued on another line", matcher.group(1));
  }

  @Test
  public void givenRegex_whenMatchesWithoutLiteralFlag_thenShouldMatch() {
    int matches = runTest("(.*)", "text");
    assertTrue(matches > 0);
  }

  @Test
  public void givenRegex_whenMatchFailsWithLiteralFlag_thenShouldMatch() {
    int matches = runTest("(.*)", "text", Pattern.LITERAL);
    assertFalse(matches > 0);
  }

  @Test
  public void givenRegex_whenMatchesWithLiteralFlag_thenShouldMatch() {
    int matches = runTest("(.*)", "text(.*)", Pattern.LITERAL);
    assertTrue(matches > 0);
  }

  @Test
  public void givenRegex_whenMatchFailsWithoutMultilineFlag_thenShouldMatch() {
    int matches = runTest("dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox");
    assertFalse(matches > 0);
  }

  @Test
  public void givenRegex_whenMatchesWithMultilineFlag_thenShouldMatch() {
    int matches = runTest("dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox", Pattern.MULTILINE);
    assertTrue(matches > 0);
  }

  @Test
  public void givenRegex_whenMatchesWithEmbeddedMultilineFlag_thenShouldMatch() {
    int matches = runTest("(?m)dog$", "This is a dog" + System.getProperty("line.separator") + "this is a fox");
    assertTrue(matches > 0);
  }
}
