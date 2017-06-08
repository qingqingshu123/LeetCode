package Arrays.Duplicate;

import java.util.HashSet;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {

    }
    //排序 hashset O(n）空间
    public int firstMissingPositive1(int[] nums) {
        if(nums == null || nums.length <=0)
            return 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
           if(nums[i] > 0 && !set.contains(nums[i]))
               set.add(nums[i]);
        }
        for (int i = 1; i <=set.size() + 1 ; i++) {
            if(!set.contains(i))
                return i;
        }
        return 1;
    }
    //左程云
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length <=0)
            return 1;
        int l = 0;
        int r = nums.length;
        while (l < r){
            if(nums[l] == l+1)
                l++;
            else if(nums[l] <l || nums[l] > r || nums[l] == nums[nums[l] - 1]){
                //l = nums[l] -1
                swap(nums, l, --r);//没用的数
            }else {
                swap(nums,l, nums[l] - 1);
            }
        }
        return l+1;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
