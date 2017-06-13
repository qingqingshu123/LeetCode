package String.Other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct(" as","ddsa"));
        System.out.println(canConstruct("as","ddsa"));
        System.out.println(canConstruct("as1","ddsa"));


    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() < 1)
            return true;
        if(magazine == null || magazine.length()< 1)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if(map.containsKey(magazine.charAt(i)))
                map.put(magazine.charAt(i),map.get(magazine.charAt(i)) + 1);
            else
                map.put(magazine.charAt(i), 1);
        }
        for (int i = 0; i <ransomNote.length() ; i++) {
            if(map.containsKey(ransomNote.charAt(i))){
                if(map.get(ransomNote.charAt(i)) == 1)
                    map.remove(ransomNote.charAt(i));
                else
                    map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            }
            else
                return false;
        }
        return true;
    }
}
