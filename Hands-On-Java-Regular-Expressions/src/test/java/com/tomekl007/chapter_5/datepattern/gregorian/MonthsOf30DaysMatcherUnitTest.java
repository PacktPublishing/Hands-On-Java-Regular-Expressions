package com.tomekl007.chapter_5.datepattern.gregorian;


import com.tomekl007.chapter_5.datepattern.DateMatcher;
import com.tomekl007.chapter_5.datepattern.gregorian.testhelper.GregorianDateTestHelper;
import org.junit.Test;

public class MonthsOf30DaysMatcherUnitTest {

    private DateMatcher matcher = new MonthsOf30DaysMatcher();

    private GregorianDateTestHelper testHelper = new GregorianDateTestHelper(matcher);

    @Test
    public void whenMonthIsShort_thenMonthContainsUpTo30Days() {
        testHelper.assertMonthsOf30Days();
    }
}