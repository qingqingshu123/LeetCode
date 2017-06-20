package Niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(k<1 || n<1 || k>n) System.out.println(0);
        int sum1 = 0;
        for (int i = n-1; i > n-k-1; i--) {
            sum1+=i;
        }
        long res = 0;
        for (int i = n; i < sum1; i+=n) {
            List<List<Integer>> res1 = new ArrayList<List<Integer>>();
            List<Integer> cur = new ArrayList<Integer>();
            rec(res1, cur, 0, k, i, 0, n);
            res += res1.size();
        }
        System.out.println(res % 1000000007);
    }
    private static void rec(List<List<Integer>> res, List<Integer> cur, int sum, int k, int n, int level,int mm) {
        if(sum==n && k==0) {
            res.add(new ArrayList(cur));
            return;
        } else if(sum>n || k<=0) return;
        for(int i=level; i<=mm-1; i++) {
            cur.add(i);
            rec(res, cur, sum+i, k-1, n, i+1,mm);
            cur.remove(cur.size() - 1);
        }
    }


}