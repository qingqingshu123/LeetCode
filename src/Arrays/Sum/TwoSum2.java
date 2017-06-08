package Arrays.Sum;

/**
 * Created by jixiaoqiang on 2017/6/4.
 */
public class TwoSum2 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int [] indices  = new int[2];
        if(numbers != null && numbers.length > 1){
            int lo = 0;
            int hi = numbers.length - 1;
            while(lo < hi){
                int sum = numbers[lo] + numbers[hi];
                if(target == sum){
                    indices[0] = lo + 1;
                    indices[1] = hi + 1;
                    return  indices;
                }
                else if(sum > target)
                    hi --;
                else
                    lo ++;
            }
        }
        return indices;
    }

}
