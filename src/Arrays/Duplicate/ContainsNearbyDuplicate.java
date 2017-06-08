package Arrays.Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {

    }
    //在k范围大小的区间内寻找重复的的数
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 0 || k <= 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k)
                set.remove(nums[i - k - 1]);
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
