package Arrays.Sort;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class SortColors {
    public static void main(String[] args) {

    }
    //一共三种数  快排中的三向切分  以1位哨兵
    //一个遍历变量 两个边界变量
    public void sortColors(int[] nums) {
        if( nums == null || nums.length <= 0)
            return;
        int bit = 1;
        int i  = 0;
        int lt = 0;
        int gt = nums.length -1;
        while(i <= gt){
            if(nums[i] < bit)
                swap(nums, lt++, i++);
            else if(nums[i] > bit)
                swap(nums,i, gt--);
            else
                i++;
        }

    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
