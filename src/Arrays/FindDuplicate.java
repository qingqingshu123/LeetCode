package Arrays;

/**
 * Created by jixiaoqiang on 2017/6/6.
 */
public class FindDuplicate {
    public static void main(String[] args) {

    }
    //暴力解法
    public int findDuplicate1(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
           for (int j = i + 1; j < len; j++){
               if((nums[i] ^ nums[j]) == 0)
                   return nums[i];
           }
        }
        return 0;
    }
    //出现两次及以上的数
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int last = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp =last ^ nums[i];
                if(last == tmp)
                    return nums[i];
                last = tmp;
            }

        return 0;
    }
}
