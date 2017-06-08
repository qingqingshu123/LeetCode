package Arrays.Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

    }
    //k = nums.length
    //O(N) 时间和空间  排序省空间费时间
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
