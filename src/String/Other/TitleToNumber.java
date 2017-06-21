package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        if(s== null || s.length()< 1)
            return 0;
        int i = 0;
        while(i<s.length() && s.charAt(i)==' ')
            i++;
        if(i == s.length())
            return 0;
        int res = 0;
        while(i< s.length() && s.charAt(i)!=' '){
            res = (s.charAt(i)-'A'+1)+ (res * 26);
            i++;
        }
        return res;
    }
}
