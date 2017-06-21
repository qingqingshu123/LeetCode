package Other;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length <1)
            return 0;
        int res = nums[0];
        for(int i=1; i< nums.length;i++)
            res^=nums[i];
        return res;
    }
}
