package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class MoveZeroes {
    public static void main(String[] args) {

    }
    //破坏了原有的顺序
    public void moveZeroes1(int[] nums) {
        if(nums == null || nums.length <= 0)
            return;
        int start = 0;
        int end = nums.length -1;
        while(start < end){
            while(start < end && nums[start] != 0)
                start ++;
            while(start < end && nums[start] == 0)
                end --;
            if(start >= end)
                break;
            swap(nums, start, end);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    //都从一头开始移动保持顺序
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 0)
            return;
        int len = nums.length;
        int start = 0;
        int end =0;
        while(start < len && end < len){
            while(start < len && nums[start] != 0)
                start ++;
            while(end < len && nums[end] == 0)
                end ++;
            if(start >= len || end >= len)
                break;
            if(start < end)
                swap(nums, start, end);
            else
                end ++;
        }
    }
}
