package Arrays;

import java.util.HashMap;

/**
 * Created by jixiaoqiang on 2017/6/6.
 * 560
 */
public class SubarraySum {
    public static void main(String[] args) {

    }
    //最长子数组  朝着最长的方向努力 左程云 每个数都是正数
    public int subarraySum1(int[] nums, int k) {
        if(nums == null ||  nums.length ==0)
            return 0;
        int left = 0;
        int right = 0;
        int len = 0;
        int sum = 0;
        while(right < nums.length){
            if(sum == k){
                len = Math.max(right -left + 1 , len);
                sum -= nums[left++];
            }
            else if(sum < k){
                right++;
                if(right == nums.length)
                    break;
                sum += nums[right];
            }

            else{
                sum -= nums[left++];
            }
        }
        return len;
    }

    //最长子数组 有正有负有0  以。。。结尾或开始的子数组数组
    //map存储 sum累加和的索引i
    public int subarraySum(int[] nums, int k) {
        if(nums == null ||  nums.length ==0)
            return 0;
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0,-1); //这个必须加
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];//s[i]
            if(hs.containsKey(sum - k)){
                len = Math.max(len, i - hs.get(sum - k));
            }
            if(!hs.containsKey(sum)){
                hs.put(sum, i);
            }
        }
        return len;
    }
}
