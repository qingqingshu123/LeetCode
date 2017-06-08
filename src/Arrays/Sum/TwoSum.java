package Arrays.Sum;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by jixiaoqiang on 2017/5/31.
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] arr = {3,2,4};
        for(int i : twoSum3(arr, 6))
            System.out.println(i);
    }
    /**
    * method1  暴力解法 O(n^2)
    */
    public  static int[] twoSum1(int[] nums, int target) {
        int [] indices = new int [2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    /**
     * method2   排序 二分搜索  O(nlogn)  不成功
     * 不允许排序   原来索引改变
     */
    public  static int[] twoSum2(int[] nums, int target) {
        int [] indices = new int [2];
        int len = nums.length;
        Arrays.sort(nums);//不允许排序   原来索引改变

        for(int i = 0; i < len; i++){
            int index = binsearch(nums, target - nums[i], i, len-1);
            if(nums[i] + nums[index] == target){
                indices[0] = i;
                indices[1] = index;
                return indices;
            }
        }
        return indices;
    }

    private static int binsearch(int []nums, int target, int s, int e){
        int lo = s;
        int hi = e;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target)
                hi = mid - 1;
            else if(nums[mid] < target)
                lo = mid + 1;
            else
                return mid;
        }
        if(lo > e)
            lo = lo - 1;
        return lo;
    }

    /**
     * method3 O(n) 使用map 借鉴
     */
    public  static int[] twoSum3(int[] nums, int target) {
        int [] indices = new int [2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                indices[0] = map.get(target - nums[i]);
                indices[1] = i; 
                return indices;
            }
            map.put(nums[i], i);
        }
        return indices;
    }
}

