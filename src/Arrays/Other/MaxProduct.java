package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/11.
 */
public class MaxProduct {
    public static void main(String[] args) {

    }
    //主要找到负数的个数  遇到0 重新开始 不能解决
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length < 1)
            return  0;
        //从当前i开始 后面的0之前的负数的个数
        int[] help = new int[nums.length];
        int count = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            if(nums[i] > 0)
                help[i] = count;
            else if(nums[i] < 0)
                help[i] = ++count;
            else {
                count=0;
                help[i] = 0;
            }
        }
        int max = Integer.MIN_VALUE;
        int tmp = 1;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                tmp*= nums[i];
            else if(nums[i] < 0){
                if(help[i] > 1)
                    tmp*=nums[i];
                else
                    tmp = 1;
            }else{
                tmp = 1;
            }
            max = Math.max(max, Math.abs(tmp));
        }
        return max;
    }

    public int maxProduct1(int[] nums) {
        if(nums == null || nums.length < 1)
            return  0;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        int maxEnd = 0;
        int minEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEnd = max * nums[i];
            minEnd = min * nums[i];

            max = Math.max(nums[i], Math.max(maxEnd, minEnd));
            min = Math.min(nums[i], Math.min(maxEnd, minEnd));
            res = Math.max(max, res);
        }

        return res;
    }
}
