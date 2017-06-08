package Arrays.Duplicate;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class MissingNumber {
    public static void main(String[] args) {

    }
    //求和
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int len = nums.length;
        int totalSum = len;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            totalSum += i;
        }
        return totalSum - sum;
    }
}
