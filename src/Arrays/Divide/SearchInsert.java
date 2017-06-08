package Arrays.Divide;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class SearchInsert {
    public static void main(String[] args) {

    }
    //标准的二分搜索
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length <= 0)
            return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid -1;
        }
        return lo;
    }
}
