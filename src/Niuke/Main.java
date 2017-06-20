package Niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jixiaoqiang on 2017/6/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int n = in.nextInt();
        int [] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        Arrays.sort(height);

//        for (int i = 1; i <= height.length-2; i++) {
//            max = Math.max(max, Math.max(height[i]-height[i-1],height[i+1]-height[i]));
//        }

        for (int i = 2; i <= height.length-3; i++) {
            max = Math.max(max, Math.max(height[i]-height[i-2],height[i+2]-height[i]));
        }
        //max = Math.max(max, Math.max(height[1]-height[0],height[2]-height[1]));
        max = Math.max(max, Math.max(height[height.length-1]-height[height.length-3],height[2]-height[0]));
        System.out.println(max);
    }


}
