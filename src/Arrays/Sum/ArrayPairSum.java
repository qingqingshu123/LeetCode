package Arrays.Sum;

import java.util.Arrays;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ArrayPairSum {
    public static void main(String[] args) {

    }
    //形成序列,使得每次取两个数中最小的一个，使得所有选的数的和最大 牛客的题
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        Arrays.sort(nums);
        int sum = 0;
        for(int i =  nums.length -2; i >= 0; i-=2)
            sum+= nums[i];
        return sum;
    }
}
