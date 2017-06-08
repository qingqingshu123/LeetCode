package Arrays.Duplicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class FindDuplicates {
    public static void main(String[] args) {

    }
    //所有数都添加进去然后删除 剩下的就是 时间超了
    public List<Integer> findDuplicates1(int[] nums) {
        if(nums == null || nums.length <= 0)
            return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            list.add(nums[i]);
        }

        for (int i = 1; i <=nums.length ; i++) {
            int index = list.indexOf(i);
            if(index != -1)
                list.remove(index);
        }
        return list;
    }


    //实际上是排序
    //是将nums[i]置换到其对应的位置nums[nums[i]-1]上去，
    //比如对于没有重复项的正确的顺序应该是[1, 2, 3, 4, 5, 6, 7, 8]，
    // 而我们现在却是[4,3,2,7,8,2,3,1]，我们需要把数字移动到正确的位置上去，
    // 比如第一个4就应该和7先交换个位置，以此类推，
    // 最后得到的顺序应该是[1, 2, 3, 4, 3, 2, 7, 8]，
    // 我们最后在对应位置检验，如果nums[i]和i+1不等，
    // 那么我们将nums[i]存入结果res中即可
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return list;
        //从头开始把对应的数换到正确的位置
        for (int i = 0; i < nums.length ; i++) {
            //这里是个易错点  主要是把nums[i] 放对位置
            if(nums[nums[i]-1] != nums[i]){
                swap(nums, i, nums[i] - 1);
                //每次交换后当前位置是否正确不确定,要重新从当前位开始
                --i;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != i+1)
                list.add(nums[i]);;
        }
        return list;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    //这里nums的数有3种情况：
    // 出现1次，出现2次，出现0次。
    // 我们找第二种。
    // 出现2次，比如element 8出现2次，那么我们按照element的值来走到下一个的时候，会有2次走到nums[8]。
    // 标记一下，这样下次来的时候就知道了。。比如把正的换成负的，下次来的时候发现是个负数，
    // 就知道我们来过一次。当然，想赢的根据element的值来走的时候，如果是负数，要换成正数
    //用nums[i] 中的值作为索引，对应的值作为重复判断的标志
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return list;
        for (int i = 0; i < nums.length; i++) {
            int next = Math.abs(nums[i]) - 1;
            if (nums[next] < 0) list.add(next+1);
            else nums[next] = -nums[next];
        }
        return list;
    }
}





