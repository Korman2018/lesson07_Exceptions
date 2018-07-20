package com.epam.codingBat.logic2;

/**
 * Given 3 int values, a b c, return their sum. However, if one of the values is
 * the same as another of the values, it does not count towards the sum.
 */
public class LoneSum {
    public static void main(String[] args) {
        System.out.println(loneSum(3, 2, 3));
    }

    public static int loneSum(int a, int b, int c) {
//         приличный вариант

//        if (a == b) {
//            return a == c ? 0 : c;
//        }
//        if (a == c) {
//            return b;
//        }
//        return b == c ? a : a + b + c;

        //непонятно, зато в одну строчку )
        return a == b ? a == c ? 0 : c : a == c ? b : b == c ? a : a + b + c;
    }
}
