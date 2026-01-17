package de.uni_passau.fim.prog1.tutorium.tutorial1.exercise07;

import java.util.Random;

/**
 * In 1582, the Gregorian calendar was introduced. Since then, leap years have been used
 * for correction purposes, in which February has 29 days instead of 28. The rule for leap
 * years is as follows: if the year is divisible by 4, it is a leap year, unless the year is also
 * divisible by 100. If the year is also divisible by 400, it is a leap year.
 * <p>
 * Examples for leap years: 2016 (divisible by 4), 2000 (divisible by 100, but also divisible by 400).
 * <p>
 * Examples for non leap years: 1580 (before 1582), 2015 (not divisible by 4), 1900 (divisible by 100 but not by 400).
 * <p>
 * <p>
 * Create a program that calculates for a given year <code>year</code> whether it is a leap year.
 * <code>year</code> should be randomly determined with the following program code:
 * <code>int year = new Random().nextInt(5000);</code>
 */
public class LeapYear {
    public static void main(String[] args) {
        int year = new Random().nextInt(5000);

        //Introduction of leap years with the Gregorian calendar since 1582.
        if (year < 1582) {
            System.out.println("The year " + year + " is no leap year"
                    + " because the Gregorian calendar is only valid since 1582.");
        } else {
            boolean isLeapYear;
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    } else {
                        isLeapYear = false;
                    }
                } else {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = false;
            }

            if (isLeapYear) { //The same as isLeapYear == true
                System.out.println("The year " + year + " is a leap year.");
            } else {
                System.out.println("The year" + year + " is no leap year.");
            }
        }
    }

    /**
     * Alternative solution approach in one method.
     * Only checks cases where the year can be a leap year.
     * 1.) Leap years are divisible by 400 (e.g., 2000).
     * 2.) The leap year is divisible by 4, but not by 100 (e.g., 2016).
     *
     * @param year The year to be checked.
     * @return if the year is a leap year.
     */
    private boolean isLeapYear(int year) {
        if (year >= 1582) {
            if (year % 400 == 0 || (year % 4 == 0 && (year % 100 != 0))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Very short but more complex solution.
     * Checked in the same way as {@link #isLeapYear(int)}.
     * <p>
     * Note the parentheses!
     * First, it checks whether the given year is greater than 1582.
     * If this is the case, it checks whether the year can be a leap year.
     * If the year is divisible by 400, the year is a leap year and the rest of the
     * <code>(year % 4 == 0) && (year % 100 != 0)</code> is no longer checked.
     * If the year is not divisible by 400, it is still checked whether it is divisible by 4 and at the same time not
     * divisible by 100.
     *
     * @param year The year to be checked.
     * @return if the year is a leap year.
     */
    private boolean isLeapYearShortened(int year) {
        return year >= 1582 && (year % 400 == 0 || (year % 4 == 0) && (year % 100 != 0));
    }
}
