package Other;

import java.util.HashSet;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int len = candies.length;
        HashSet<Integer> set = new HashSet<>();
        //共有多少种糖
        for(int i = 0; i < candies.length; i++){
            if(!set.contains(candies[i]))
                set.add((candies[i]));
        }
        return set.size()>len/2? len/2:set.size();

    }
}
