package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/7.
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {

    }
    //当前最多放多少花 两边 策略 贪心 从左到右此处能放就放
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed == null || flowerbed.length <=0)
            return false;
        if(n < 2 && flowerbed[0] == 0 && flowerbed.length == 1 )
            return true;
        int n1 = n;

        for (int i = 0; i < flowerbed.length - 1 ; i++) {
            if(i == 0 && flowerbed[i] ==0 && flowerbed[1] == 0){
                n1--;
                flowerbed[i] = 1;
            }

            if(i>0 && flowerbed[i-1] ==0 && flowerbed[i]==0 && flowerbed[i+1] == 0) {
                n1--;
                flowerbed[i] = 1;
            }
        }
        if( flowerbed.length > 1 && flowerbed[flowerbed.length-1] ==0 && flowerbed[flowerbed.length - 2] == 0){
            n1--;
        }

        if(n1 > 0)
            return false;
        else
            return true;
    }
}
