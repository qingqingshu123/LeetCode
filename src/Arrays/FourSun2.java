package Arrays;

import Arrays.Other.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/4.
 */
public class FourSun2 {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        List<Interval> ls = new ArrayList<>();
        Iterator<Interval> IT = ls.iterator();

        Arrays.sort(D);
        Arrays.sort(C);
        Arrays.sort(B);
        Arrays.sort(A);
        int len = A.length;
        int loA = 0, loB = 0;
        int hiC =len - 1, hiD =len - 1;
        int count = 0;
        while(loA <= len || loB <= len || hiC > 0 || hiD > 0)
        {
            int sum = A[loA]+B[loB]+C[hiC]+D[hiD];
            if(sum == 0){
                count++;
                loA++;
                hiC--;
            }else if(sum < 0){
                loA++;
                loB++;
            }else{
                if(hiC > 0 && hiD >0){
                    if(C[hiC - 1] > D[hiD -1]){
                        hiD --;
                    }
                    else
                        hiC--;
                }
                else if(hiC <=0)
                hiC--;
                hiD--;
            }



        }



        return count;
    }
}
