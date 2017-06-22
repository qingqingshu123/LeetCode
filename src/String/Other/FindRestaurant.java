package String.Other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jixiaoqiang on 2017/6/22.
 */
public class FindRestaurant {
    public static void main(String[] args) {
        String [] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String [] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] rs= findRestaurant(list1, list2);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hs = new HashMap<>();
        HashMap<String, Integer> hs1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hs.put(list1[i],i);
        }
        //注意一个hashmap 会有list1中有而list2中没有的项
        for (int i = 0; i < list2.length; i++) {
            if(hs.containsKey(list2[i]))
                hs1.put(list2[i], hs.get(list2[i])+i);
        }
        int min = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<>();
        for(String i: hs1.keySet()){
            if(hs1.get(i) < min){
                min = hs1.get(i);
                res = new ArrayList<>();
                res.add(i);
            }else if(hs1.get(i) == min){
                res.add(i);
            }
        }
        String[] res1 = new String[res.size()];
        Iterator<String> it = res.iterator();
        int i = 0;
        while (it.hasNext()){
            res1[i++] = it.next();
        }
        return res1;
    }
}
