package com.tomekl007.chapter_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerfCompileTest {

  @Test
  public void match_with_recompile(){
    // Given
    long start = System.currentTimeMillis();
    List<String> values = Arrays.asList("match", "mate", "mark", "matte");

    // When
    for(int i = 0; i < 10_000_000; i++) {

      Pattern pattern = Pattern.compile("mat(ch|e|rk)");
      for (String value : values) {
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
          someLogic(value);
        }
      }
    }

    // Then
    System.out.println("time taken(with recompile): " + (System.currentTimeMillis() - start));
  }



  @Test
  public void match_with_one_compile(){
    // Given
    long start = System.currentTimeMillis();
    List<String> values = Arrays.asList("match", "mate", "mark", "matte");
    Pattern pattern = Pattern.compile("mat(ch|e|rk)");

    // When
    for(int i = 0; i < 10_000_000; i++) {
      for (String value : values) {
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
          someLogic(value);
        }
      }
    }

    // Then
    System.out.println("time taken(one compile): " + (System.currentTimeMillis() - start));
  }

  private void someLogic(String value) {
    int i = value.hashCode() << 2;

  }
}
