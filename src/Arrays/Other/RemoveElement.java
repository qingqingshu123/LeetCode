package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class RemoveElement {
    public static void main(String[] args) {

    }
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length <= 0)
            return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                nums[index++] = nums[i];
        }
        return  index;
    }
}
