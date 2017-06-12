package Arrays.Divide;

/**
 * Created by jixiaoqiang on 2017/6/11.
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int [] res = {-1, -1};
        if(nums == null || nums.length <1)
            return res;
        int lo = 0;
        int hi = nums.length -1;
        int mid  =0;
        while (lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                int s = mid;
                while(s > 0 && nums[s - 1] == target){
                    s--;
                    if(s == 0)
                        break;
                }
                res[0] = s;
                int e = mid;
                while(e < nums.length -1 && nums[e + 1] == target){
                    e++;
                    if(e == nums.length - 1)
                        break;
                }
                res[1] = e;
                return res;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid -1;
            }
        }
        return res;
    }
}
