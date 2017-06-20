package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//所有排列组合类的做法
public class 排列组合 {
    public static void main(String[] args) {
        int [] arr ={1,3,4,7};
        for(ArrayList<Integer> i : permute(arr)){
            for (Integer j: i)
                System.out.print(j);
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num){
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path=new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();//去重
        permuteHelper(results,path,num,set);
        return results;
    }

    private static void permuteHelper(ArrayList<ArrayList<Integer>> results,ArrayList<Integer> path,int[] num,HashSet<Integer> set){
        if(path.size()==num.length){ //是方法结束的条件
            results.add(new ArrayList<Integer>(path));
            return;
        }
        //可以重复使用
        for(int i =0;i<num.length;i++){
            //提议要求要跳过那些条件
            if(!set.contains(i)){//去重
                path.add(num[i]);
                set.add(i);//去重
                permuteHelper(results, path, num, set);
                path.remove(path.size() - 1);
                set.remove(i);//去重
            }

        }
    }
}