package Bits;

/**
 * Created by jixiaoqiang on 2017/6/20.
 */
public class FindComplement {
    public int findComplement(int num) {
        int i = 0;//统计位数
        int n = num;
        while(n != 0){
            i++;
            n >>>= 1;
        }
        //补数
        return (1<<i)-1-num;
    }
}
