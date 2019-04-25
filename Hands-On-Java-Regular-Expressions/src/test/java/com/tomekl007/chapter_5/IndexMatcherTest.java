package com.tomekl007.chapter_5;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class IndexMatcherTest {
  @Test
  public void givenMatch_whenUsingOnSentence_theShouldGetIndices() {
    //given
    Pattern pattern = Pattern.compile("cat");
    Matcher matcher = pattern.matcher("This cat is mine");

    //when
    matcher.find();

    //then
    assertEquals(5, matcher.start());
    assertEquals(8, matcher.end());
  }

}
