package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class FindPeakElement {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;

        if(nums[0] > nums[1] && nums[0] > -1)
            return 0;
        if(nums[nums.length -1] > nums[nums.length - 2])
            return nums.length -1;

        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]){
                return i;
            }
        }
        return 0;
    }
}
