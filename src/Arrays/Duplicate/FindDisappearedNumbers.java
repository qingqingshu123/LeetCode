package Arrays.Duplicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr ={4,3,2,7,8,2,3,1};
        //System.out.println(findDisappearedNumbers(arr));
    }
    //通过添加删除来操作  耗时太长
    public  List<Integer> findDisappearedNumbers1(int[] nums) {
        if(nums == null || nums.length <= 0)
            return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <=nums.length ; i++) {
            list.add(i);

        }
        for (int i = 0; i <nums.length ; i++) {
            int index = list.indexOf(nums[i]);
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
    public List<Integer> findDisappearedNumbers2(int[] nums) {
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
                list.add(i+1);;
        }
        return list;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    //以索引i对应的数值nums[i] - 1 作为索引，把对应的值设为负数，
    // 最后再变量一遍，数为正数的就是没有对应的索引值+1
    public  List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length <= 0)
            return list;
        for (int i = 0; i < nums.length; i++) {
            int next = Math.abs(nums[i]) - 1;
            if (nums[next] < 0) continue;
            else nums[next] = -nums[next];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;
            else list.add(i+1);
        }
        return list;
    }
}
