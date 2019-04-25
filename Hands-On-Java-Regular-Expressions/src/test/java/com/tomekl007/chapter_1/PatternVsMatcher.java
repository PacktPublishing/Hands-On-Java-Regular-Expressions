package com.tomekl007.chapter_1;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class PatternVsMatcher {
  @Test
  public void givenText_whenSimpleRegex_thenMatches() {
    Pattern pattern = Pattern.compile("foo");
    Matcher matcher = pattern.matcher("foo");
    assertTrue(matcher.find());
  }
}
