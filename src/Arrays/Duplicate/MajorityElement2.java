package Arrays.Duplicate;

import java.util.*;

/**
 * Created by jixiaoqiang on 2017/6/6.
 */
public class MajorityElement2 {
    public static final int K = 3;
    public static void main(String[] args) {

    }
    public List<Integer> majorityElement(int[] nums) {
        boolean find = false;
        List<Integer> list =new ArrayList<Integer>();
        if(nums == null || nums.length <=K){
            for (int i = 0; i < nums.length ; i++) {
                list.add(nums[i]);
            }
            return list;
        }

        HashMap<Integer,Integer> cand = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cand.containsKey(nums[i])) {
                cand.put(nums[i], cand.get(nums[i]) + 1);
            } else {
                //维持K-1个cand
                if (cand.size() == K - 1) {
                    allCandMinuteOne(cand);
                } else {
                    cand.put(nums[i], 1);
                }
            }
        }

        HashMap<Integer,Integer> reals = getReals(nums,cand);
        for(Map.Entry<Integer,Integer> entry :reals.entrySet()){
            if(entry.getValue() > nums.length / 3){
                find = true;
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private void allCandMinuteOne(HashMap<Integer,Integer> cand){
        List<Integer> removeList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry :cand.entrySet()){
            if(entry.getValue() == 1)
                removeList.add(entry.getKey());
            cand.put(entry.getKey(),entry.getValue()-1);
        }

        for(Integer i: removeList){
            cand.remove(i);
        }

    }
    private HashMap<Integer, Integer> getReals(int[] nums, HashMap<Integer,Integer> cand){
        HashMap<Integer,Integer> reals = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length ; i++) {
            if(cand.containsKey(nums[i])){
                if(reals.containsKey(nums[i])) {
                    reals.put(nums[i], reals.get(nums[i]) + 1);
                }
                else{
                    reals.put(nums[i],1);
                }
            }
        }
        return reals;
    }
}
