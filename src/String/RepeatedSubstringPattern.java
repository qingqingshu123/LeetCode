package String;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("a"));
        System.out.println(repeatedSubstringPattern("  "));
        System.out.println(repeatedSubstringPattern(""));
        System.out.println(repeatedSubstringPattern("abcabc"));
        System.out.println(repeatedSubstringPattern("abcabd"));



    }
    //长度是偶数  左一半和右一半一样  想法太简单
    public static boolean repeatedSubstringPattern(String s) {
        if(s==null || s.length() <1)
            return false;
        int len = s.length() / 2;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) != s.charAt(len+i))
                return false;
        }
        return true;
    }
}
