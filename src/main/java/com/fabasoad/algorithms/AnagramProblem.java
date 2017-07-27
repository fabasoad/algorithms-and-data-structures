package com.fabasoad.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by efabizhevsky on 7/26/2017.
 */
public class AnagramProblem {

    public static void main(String[] args) {
        String[][] data = new String[2][2];
        data[0][0] = "tea";
        data[0][1] = "tea";
        data[1][0] = "ate";
        data[1][1] = "ata";
        int[] result;
        for (int i = 0; i < data.length; i += 2) {
            result = getMinimumDifference(data[i], data[i + 1]);
            System.out.println(">> " + Arrays.toString(result));
        }
    }

    private static int getMinimumDifference(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        int i;
        for (i = 0; i < a.length(); i++) {
            map.compute(a.charAt(i), (k, v) -> (v == null ? 0 : v) + 1);
        }
        for (i = 0; i < b.length(); i++) {
            map.compute(b.charAt(i), (k, v) -> (v == null ? 0 : v) - 1);
        }
        int result = 0;
        for (Integer val : map.values()) {
            if (val > 0) {
                result += val;
            }
        }
        return result;
    }

    private static int[] getMinimumDifference(String[] a, String[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                result[i] = -1;
            } else {
                result[i] = getMinimumDifference(a[i], b[i]);
            }
        }
        return result;
    }
}
