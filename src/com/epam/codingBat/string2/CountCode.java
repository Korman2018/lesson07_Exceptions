package com.epam.codingBat.string2;

/**
 * Return the number of times that the string "code" appears anywhere in
 * the given string, except we'll accept any letter for the 'd', so
 * "cope" and "cooe" count.
 */
public class CountCode {
    public static void main(String[] args) {
        System.out.println(countCode("aaacodebbb"));
    }

    public static int countCode(String str) {
        int countMatches = 0;
        int pointer = 0;
        int endOfSequence = str.length() - 3;

        while (pointer < endOfSequence) {
            if (str.substring(pointer, pointer + 4).matches("co\\we")) {
                pointer = pointer + 4;
                countMatches++;
            } else {
                pointer++;
            }
        }
        return countMatches;
    }
}
