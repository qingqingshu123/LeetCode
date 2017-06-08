package Arrays.Duplicate;

import java.util.Arrays;

/**
 * Created by jixiaoqiang on 2017/6/6.
 */
public class MajorityElement {
    public static void main(String[] args) {

    }
    //排序找到连续出现的子数组
    //统计出现的次数 词频统计
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < (nums.length+1) / 2; i++) {
            if(nums[i] == nums[i + nums.length/2])
                return nums[i];
        }
        return nums[0];
    }
    //任意两个数不同就删除 剩下的最后一个或两个就是 （刚好是一半不行）
    //出现次数大于N/K次的数  左程云
    public int majorityElement(int[] nums) {
        int times = 0;//用一个变量做了统计 代替了一个数组
        int cand = 0;
        for (int i = 0; i < nums.length; i++) {
            if(times ==0){
                cand = nums[i];
                times = 1;
            }else if(nums[i] == cand){
                times++;
            }else{
                times--;
            }
        }
        //cand 最有可能是 要么就没有
//        for (int i = 0; i <nums.length ; i++) {
//            if(nums[i] == cand)
//                times++;
//        }
//        if(times >= nums.length / 2)
        return cand;
    }
}
