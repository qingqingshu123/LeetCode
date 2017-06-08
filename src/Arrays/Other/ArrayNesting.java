package Arrays.Other;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ArrayNesting {
    public static void main(String[] args) {

    }

    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(!set.contains(j)){
                set.add(j);
                j= nums[j];
                size ++;
            }
            if(size > max)
                max = size;
            size = 0;
        }
        return max;
    }
}
