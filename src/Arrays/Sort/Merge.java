package Arrays.Sort;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class Merge {
    public static void main(String[] args) {

    }
    //辅助数组
    //不用辅助数组 从右向左执行
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        if(m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[2];
            }
            return;
        }
        int m1 = m- 1;
        int n1 = n -1;
        for (int i = m1 + n1 + 1; i >=0 ; i--) {
            if(n1 < 0) return;
            if(m1 < 0) nums1[i] = nums2[n1--];
            else if(nums1[m1] > nums2[n1]) nums1[i] = nums1[m1--];
            else nums1[i] = nums2[n1--];
        }
    }
}
