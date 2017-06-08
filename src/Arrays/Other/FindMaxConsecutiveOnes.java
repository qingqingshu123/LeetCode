package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {

    }
    //双指针
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int count = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        int len = nums.length;
        while(ptr1 < len && ptr2 < len){
            ptr2 = ptr1;
            while(ptr2 < len &&  nums[ptr2] == 1)
                ptr2++;
            if(ptr2 - ptr1 >count)
                count = ptr2 -ptr1;
            ptr1 = ptr2;
            while(ptr1 < len && nums[ptr1] == 0)
                ptr1++;
        }
        return count;

    }
}
