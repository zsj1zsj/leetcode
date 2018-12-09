package saicinterview;

import java.util.Arrays;

public class Quest {
    public static void main(String[] args) {
        String[] colors = { "blue", "red", "green", "yellow", "orange","black" };
        Arrays.sort(colors);
        int s2 = Arrays.binarySearch(colors, "orange");
        int s3 = Arrays.binarySearch(colors, "violet");
        System.out.println(Arrays.binarySearch(colors, "violet"));
        System.out.print(s2 + "" + s3);
    }
}

