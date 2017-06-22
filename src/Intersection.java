import java.util.*;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class Intersection {
    //如何减少空间的复杂度   ？？
    public int[] intersection1(int[] nums1, int[] nums2) {
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


    public int[] intersection2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return null;
        if(nums1.length<1 || nums2.length <1)
            return new int[0];

        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int i = 0; i < nums1.length;i++){
            if(map1.containsKey(nums1[i]))
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            else
                map1.put(nums1[i],1);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i<nums2.length;i++){
            if(map1.containsKey(nums2[i])){
                arr.add(nums2[i]);
                if(map1.get(nums2[i]) >1)
                    map1.put(nums2[i], map1.get(nums2[i]) -1);
                else
                    map1.remove(nums2[i]);
            }
        }
//        //arr.toArray();需要一个个数组元素的转换
//        Integer[] res = new Integer[arr.size()];
//        LinkedList<Integer> ls = new LinkedList<>();
//        ls.toArray(res); //基本类型不能使用
//        arr.toArray(new Integer[0]); //基本类型不能使用


        //arr.toArray(res);

        int[] res = new int[arr.size()];
        Iterator<Integer> iterator = arr.iterator();
        int i = 0;
        while(iterator.hasNext()){
            res[i++] = iterator.next();
        }
        return res;
    }
}
