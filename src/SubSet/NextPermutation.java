package SubSet;

/**
 * Created by jixiaoqiang on 2017/6/20.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while (i > 0 && nums[i] <=nums[i-1]) {
            --i;
        }
        if(i == 0) { //321->123 循环
            for (int k = nums.length-1,  j = 0; k>j ; k--,j++) {
                swap(nums, k, j);
            }
            return;
        }
        int j = i;
        //反转
        for (int k = nums.length-1; k>j ; k--,j++) {
            swap(nums, k, j);
        }
        j = i;
        //System.out.println(j);
        for (;j < nums.length;j++) {
            if(nums[j] > nums[i-1]){
                swap(nums, i - 1, j);
                break;
            }
        }
    }
    private void swap(int[]arr, int i, int j){
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }
}
