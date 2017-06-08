package Arrays.Sum;
import  java.util.Arrays;
/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        int closestTarget = 11111110;
        int relTarget = 0;
        Arrays.sort(nums);
        int flag = 0;
        if(nums != null && nums.length > 2){
            for (int i = 0; i < nums.length; i++) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo < hi){
                    // -5 -4 -3 -2 -1 0 1 2 3 4 5
                    //共同努力的方向Math.abs(sum) 越来越小
                    int sum = nums[i] + nums[lo] + nums[hi] - target;
                    if(Math.abs(sum) <= closestTarget){
                        closestTarget = Math.abs(sum);
                        relTarget = sum;
                    }
                    if(sum >= 0)
                        hi --;
                    else
                        lo ++;
                }
            }
        }
        return relTarget + target;
    }
}
