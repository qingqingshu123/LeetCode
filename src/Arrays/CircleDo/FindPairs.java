package Arrays.CircleDo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class FindPairs {
    public static void main(String[] args) {
        int [] arr = {1,3,1,5,4};
        //findPairs(arr, 0);
    }

    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i] , 1);
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            boolean removeble = false;
            //这是一个要处理的点  nums[i]可能有重复 数组中还会出现
            if(map.containsKey(nums[i] + k) && map.containsKey(nums[i])){
                if(k > 0)
                    count++;
                else if(k == 0 && (map.get(nums[i] + k) > 1))
                    count ++;
                removeble = true;
            }
            if(map.containsKey(nums[i] - k)&& map.containsKey(nums[i])){
                if(k > 0)
                    count++;
                //对于0 只有一种情况
                else if(k == 0 && map.get(nums[i] + k) > 1 && removeble == false)
                    count ++;
                removeble = true;
            }
            if(removeble)
                map.remove(nums[i]);
        }
        return count;
    }
}
