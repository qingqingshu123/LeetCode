package Arrays.Update;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ThirdMaxNum {
    public static void main(String[] args) {

    }
    //想想其他方法  sort 堆排序 改成第n大的数
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length < 0)
            return 0;
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] >= firstMax){
                if(nums[i] > firstMax){
                    thirdMax = secondMax;
                    secondMax = firstMax;
                    firstMax = nums[i];
                }

            }
            else if(nums[i] >= secondMax){
                if(nums[i] > secondMax){
                    thirdMax = secondMax;
                    secondMax = nums[i];
                }

            }
            else if(nums[i] >= thirdMax)
                thirdMax = nums[i];
        }
        return thirdMax == Long.MIN_VALUE ? (int)firstMax:(int)thirdMax;
    }
}
