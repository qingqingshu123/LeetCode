package String.Other;

import java.util.HashMap;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if(s == null || s.length() < 1)
            return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
        int i = 0;
        for (; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
