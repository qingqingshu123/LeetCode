package Arrays;

/**
 * Created by jixiaoqiang on 2017/6/5.
 * 53
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }
    // O(n)
    public int maxSubArray1(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > max)
                max = sum;
            if(sum <= 0)
                sum = 0;
        }
        return max;
    }
    //分制
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int [] flagLeft = new int[1];
        int [] flagRight = new int[1];

        int max = 0;
        return max;
    }

    private  int maxval(int[] nums, int start, int end, int[] flagLeft, int[] flagRight ){
        int max = Integer.MIN_VALUE;;
        int maxLeft = 0;
        int maxRight = 0;
        if(start == end)
            return nums[start];
        int mid = end - start / 2;
        maxLeft = maxval(nums, start, mid, flagLeft,flagRight);
        maxRight = maxval(nums, mid + 1, end,flagLeft,flagRight);
        if(flagLeft[0] == flagRight[0])
            max = maxLeft + maxRight;
        else{
            max = (maxLeft > maxRight) ? maxLeft : maxRight;
        }
        return max;
    }
}
