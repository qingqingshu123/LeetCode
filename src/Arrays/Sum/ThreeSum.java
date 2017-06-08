package Arrays.Sum;

import java.util.*;

/**
 * Created by jixiaoqiang on 2017/5/31.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int [] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }

    /**
     * method1
     * 二分搜索实现  O(NlogN)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        if(nums != null && nums.length > 2){
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                int lo = i+1;
                int hi = nums.length - 1;
                while(lo < hi){
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if(sum == 0){
                        ArrayList<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[lo]);
                        ls.add(nums[hi]);
                        //重复性判断 hash
                        if(!hs.contains(ls)){
                            hs.add(ls);
                            list.add(ls);
                        }
                        lo++;
                        hi--;
                    }
                    else if(sum > 0)
                        hi--;
                    else
                        lo++;
                }
            }
        }
        return list;
    }
}
