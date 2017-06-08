package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ProductExceptSelf {
    public static void main(String[] args) {

    }

    //不能使用除法  使用除法要注意 0的个数 0 1 >1 三种情况
    //主要思想两个辅助数组来记录从左到右 和从右到左的各个乘积的情况
    //通过复用结果数组来 减小空间复杂度
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 2)
            return null;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        //复用res  lr
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i];
        }
        int tmp = 1; //rl
        for (int i = nums.length - 1; i > 0 ; i--) {
            res[i] = tmp * res[i - 1];
            tmp *= nums[i];
        }
        res[0] = tmp;
        return res;
    }
}
