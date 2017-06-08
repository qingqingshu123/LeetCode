package Arrays.SubArray;

/**
 * Created by jixiaoqiang on 2017/6/6.
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,1,3,2};
        minSubArrayLen(5,arr);
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] helpr = new int[nums.length + 1];
        helpr[0] =0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            helpr[i+1] = sum;
        }
        for (int i = 0; i < helpr.length; i++) {
            System.out.println(helpr[i]);
        }
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int index = find(helpr, sum - s);
            System.out.println("index"+i+":"+index);
            if(index != -1)
                minlen = Math.min(minlen, i - index + 1);
            System.out.println("minlen:"+minlen);
        }
        return minlen == Integer.MAX_VALUE? 0:minlen;
    }
    //寻找小于等于s的最大的一个数
    private static int find(int [] nums, int s){
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while(lo <= hi){
            mid = lo +(hi - lo) / 2;
            if(nums[mid] > s)
                hi = mid - 1;
            else{
                while(mid < nums.length - 1){
                    if(nums[mid + 1] <= s)
                        mid++;
                    else
                        return mid;
                }

            }
        }
        return -1;
    }
}
