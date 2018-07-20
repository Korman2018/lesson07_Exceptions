package com.epam.codingBat.string2;

/**
 * Given two strings, return true if either of the strings appears at the very end of
 * the other string, ignoring upper/lower case differences (in other words, the
 * computation should not be "case sensitive"). Note: str.toLowerCase() returns the
 * lowercase version of a string.
 */
public class EndOther {
    public static void main(String[] args) {
        System.out.println(endOther("Hiabc", "bc"));
    }

    public static boolean endOther(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        if (aLength > bLength) {
            return b.compareToIgnoreCase(a.substring(aLength - bLength)) == 0;
        }
        return a.compareToIgnoreCase(b.substring(bLength - aLength)) == 0;
    }
}
