package Arrays.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/6.
 */
public class SummaryRanges {
    public static void main(String[] args) {

    }
    public List<String> summaryRanges(int[] nums) {
        if(nums == null)
            return null;
        List<String> ls = new ArrayList<>();
        if(nums.length <= 0)
            return ls;
        for (int i = 0; i < nums.length;) {
            int s = i;
            while((i< nums.length -1) && (nums[i] == (nums[i + 1] - 1))){
                i++;
                //此时的i指向和前面的数属于同一区域
            }


            if((s == nums.length -1) || s == i)
                ls.add(nums[s]+"");
            else
                ls.add(nums[s]+"->"+nums[i]);
            i++;
        }
        return ls;
    }
}
