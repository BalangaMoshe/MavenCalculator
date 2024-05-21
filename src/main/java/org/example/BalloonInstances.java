package org.example;

public class BalloonInstances {
    public static int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (char ch : text.toCharArray()) {
            counts[ch - 'a']++;
        }
        int min = Integer.MAX_VALUE;

        min = Math.min(min, counts[1]);
        min = Math.min(min, counts[0]);
        min = Math.min(min, counts[11] / 2);
        min = Math.min(min, counts[14] / 2);
        min = Math.min(min, counts[13]);
        return min;
    }
}
