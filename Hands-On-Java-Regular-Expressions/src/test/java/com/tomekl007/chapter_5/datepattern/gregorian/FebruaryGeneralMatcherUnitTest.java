package com.tomekl007.chapter_5.datepattern.gregorian;


import com.tomekl007.chapter_5.datepattern.DateMatcher;
import com.tomekl007.chapter_5.datepattern.gregorian.testhelper.GregorianDateTestHelper;
import org.junit.Test;

public class FebruaryGeneralMatcherUnitTest {

    private DateMatcher matcher = new FebruaryGeneralMatcher();

    private GregorianDateTestHelper testHelper = new GregorianDateTestHelper(matcher);

    @Test
    public void whenMonthIsFebruary_thenMonthContainsUpTo28Days() {
        testHelper.assertFebruaryGeneralDates();
    }
}