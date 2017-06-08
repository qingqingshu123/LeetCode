package Arrays.Duplicate;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {

    }
    //双指针
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int end = 0;
        int start = 0;
        int index = 0;
        while(end < nums.length){
            while(end < nums.length && nums[start] == nums[end])
                end++;
            nums[index++]=nums[start];
            if(end - start >1){
                nums[index++]=nums[end-1];
            }
            start = end;
        }
        return index;
    }
}
