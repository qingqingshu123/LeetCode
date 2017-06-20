package Niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jixiaoqiang on 2017/6/16.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(k<1 || n<1 || k>n) System.out.println(0);
        int sum = 0;
        for (int i = n-1; i > n-k-1; i--) {
            sum+=i;
        }
        long res = 0;
        for (int i = n; i < sum; i+=n) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(result, cur, 0, k, i, 1,n-1);
            res+=result.size();
        }
        System.out.println(res % 1000000007);
    }

    public static void  dfs(List<List<Integer>> result, List<Integer> cur, int sum, int k, int n, int level,int num) {
        if(sum == n && k==0) {
            result.add(new ArrayList(cur));
            return;
        } else if(sum> n || k<0) return;
        for(int i=level;i<=num;i++){
            cur.add(i);
            dfs(result, cur, sum+i, k-1, n, i+1,num);
            cur.remove(cur.size()-1);
        }
    }
}
