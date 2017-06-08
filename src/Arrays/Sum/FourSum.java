package Arrays.Sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

/**
 * Created by jixiaoqiang on 2017/6/4.
 */
public class FourSum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        if(nums != null && nums.length > 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int newTarget = target - nums[i];
                threeSum(nums, i, newTarget, list, hs);
            }
        }
        return list;
    }

    public void  threeSum(int[] nums, int start ,int target,List<List<Integer>> list, HashSet<ArrayList<Integer>> hs) {
        for(int i = start+1; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target){
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(nums[start]);
                    ls.add(nums[i]);
                    ls.add(nums[lo]);
                    ls.add(nums[hi]);
                    if(!hs.contains(ls)){
                        hs.add(ls);
                        list.add(ls);
                    }
                    lo++;
                    hi--;
                }
                else if(sum > target)
                    hi--;
                else
                    lo++;
            }
        }
    }
}
