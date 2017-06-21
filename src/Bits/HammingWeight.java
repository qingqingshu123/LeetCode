package Bits;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class HammingWeight {
    public static void main(String[] args) {
       // System.out.println(hammingWeight(4294967295L));
       // System.out.println(hammingWeight(214748364));
                                           //2147483647
        //System.out.println(Integer.MAX_VALUE);
    }
    public static int hammingWeight(int n) {
        int tmp = n;
        int count = 0;
        //对负数有效
        while(tmp != 0){
            count++;

            tmp = tmp - (tmp&(~tmp+1));

        }
        return count;
    }
}
