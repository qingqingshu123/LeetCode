package Arrays.Duplicate;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int index = 1;
        for(int i = 0; i< nums.length - 1;){
            if(nums[i] != nums[i+1]){
                nums[index++] = nums[i + 1];
            }
            i++;
        }
        return index;
    }
}
