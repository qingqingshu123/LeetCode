package SubSet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by jixiaoqiang on 2017/6/20.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] findNums = {3,1,2};
        int[] nums = {5,3,1,2,4};
        //int[] res = nextGreaterElement(findNums,nums);
        //int[] res = nextGreaterElement(nums);
//        int[] res ={1};
//        for (int i = 0; i <res.length; i++) {
//            System.out.println(res[i]);
//        }
        System.out.println(nextGreaterElement(13));
    }
    public static int[] nextGreaterElement1(int[] findNums, int[] nums) {
        if(findNums == null || nums == null)
            return null;
        if(findNums.length < 1 || nums.length <1)
            return new int [0];
        int[] res = new int[findNums.length];
        Map<Integer,Integer> map = new HashMap<>();
        //O(n^2)  如何改进
//        for (int i = 0; i < nums.length; i++){
//            map.put(nums[i], -1);
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[j] > nums[i]){
//                    map.put(nums[i],nums[j]);
//                    break;
//                }
//
//            }
//        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            //对于i而言,后面的值不大于当前的i的值就出栈 还要判断空  距离i最近 后进先出的特性
            if(!stack.isEmpty() && stack.peekLast() <= nums[i])
                stack.pollLast();
            map.put(nums[i],stack.isEmpty()? -1: stack.peekLast());
            stack.addLast(nums[i]);
        }
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

    public static int[] nextGreaterElement2(int[] nums) {
        if(nums == null)
            return null;
        if(nums.length < 1)
            return new int[0];
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        //栈预处理
        for (int i = nums.length-1; i >= 0; i--) {
                stack.addLast(nums[i]);
        }
        //保留后面相对较大的
        for (int i = nums.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= nums[i])
                stack.pollLast();
            if(stack.isEmpty())
                res[i] = -1;
            else res[i] = stack.peekLast();
            stack.addLast(nums[i]);
        }
        return res;
    }
    //4331 -1  1234->1243  从右向左找到一个前一位小于后一位i   从右向左找到一个大于i位j交换
    public static int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n));
        int i = sb.length()-1;
        while (i > 0 && sb.charAt(i) <=sb.charAt(i-1)) {
            --i;
        }
        if(i == 0) return -1;
        int j = i;
        //反转
        for (int k = sb.length()-1; k>j ; k--,j++) {
            swap(sb, k, j);
        }
        j = i;
        //System.out.println(j);
        for (;j < sb.length();j++) {
            if(sb.charAt(j) > sb.charAt(i-1)){
                swap(sb, i - 1, j);
                break;
            }
        }

        if(j == sb.length())
            return -1;
        //超过最大值
        return  Long.parseLong(sb.toString()) > Integer.MAX_VALUE? -1:Integer.parseInt(sb.toString());

    }

    private static void swap(StringBuilder sb, int i, int j){
        char c = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,c);
    }
}
