package Bits;

/**
 * Created by jixiaoqiang on 2017/6/20.
 */
public class HammingDistance {
    //x^y后1的个数 n & (~n+1) 从右往左 位为1的数
    public int hammingDistance(int x, int y) {
        int res = 0;
        int n = x^y;
        while(n != 0){
            res++;
            n -= n & (~n+1);
        }
        return res;
    }
}
