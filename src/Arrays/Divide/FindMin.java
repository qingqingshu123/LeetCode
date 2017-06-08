package Arrays.Divide;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class FindMin {
    public static void main(String[] args) {

    }
    //可以O(n)遍历
    //没有重复的值
    //最小值出现在最左边 或中间
    //mid值 小于最左边值  min在左边
    //mid值 大于最左边值 再和最右边的值比较那边小在那边
    public int findMin1(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        int min = Integer.MAX_VALUE;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            min = Math.min(min, nums[mid]);
            if(nums[mid] < nums[lo])
                hi = mid - 1;
            else if(nums[mid] < nums[hi]) {
                hi = mid - 1;
            }else  {
                lo = mid + 1;
            }
        }
        return min;
    }

    //有重复的值
    //分制 通用的算法
    public int findMin(int[] nums) {
        if(nums == null || nums.length <= 0)
            return 0;
        return findMin(nums, 0, nums.length-1);
    }

    public int findMin(int[] nums, int start , int end) {
        if(end - start < 2){
            return Math.min(nums[end], nums[start]);
        }
        int mid = start + (end - start) / 2;
        return Math.min(findMin(nums, start, mid),
                        findMin(nums, mid + 1, end));

    }
}
