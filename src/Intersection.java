import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class Intersection {
    //如何减少空间的复杂度   ？？
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return null;
        if(nums1.length<1 || nums2.length <1)
            return new int[0];

        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < nums1.length;i++){
            if(!set1.contains(nums1[i]))
                set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i<nums2.length;i++){
            if(set1.contains(nums2[i])&&!set2.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        Iterator<Integer> iterator = set2.iterator();
        int i = 0;
        while(iterator.hasNext()){
            res[i++] = iterator.next();
        }
        return res;
    }
}
