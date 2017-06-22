package Arrays;

import java.util.Arrays;

/**
 * Created by jixiaoqiang on 2017/6/22.
 */
public class MinMoves {
    public static void main(String[] args) {
        int [] arr ={1,2,3,5};
        System.out.println(minMoves(arr));
        int [] arr1 ={1,2,3};
        System.out.println(minMoves(arr1));
        int [] arr3 ={1,3};
        System.out.println(minMoves(arr3));


    }
    public static  int minMoves1(int[] nums) {
        //有重复  时间复杂度太高
        if(nums == null || nums.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = nums.length;
        int res = 0;
        int index =-1;
        for (int i = 0; i < n; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
            min = Math.min(min,nums[i]);
        }
        while(max != min){
            res += max - min;
            for (int i = 0; i < n; i++) {
                if(i !=index)
                nums[i]+= max-min;
            }
            min =max;
            for (int i = 0; i < n; i++) {
                if(nums[i] > max){
                    max = nums[i];
                    index = i;
                }
            }

        }
        return res;
    }



    public static  int minMoves(int[] nums) {
        //有重复  时间复杂度太高
        if(nums == null || nums.length < 2)
            return 0;
        int res = 0;
        int index =nums.length-1;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        //只维护最小值和最大值
        while(max != min){
            index--;
            res += max - min;
            min = max;
            max = nums[index] + res;
        }
        return res;
    }
}
