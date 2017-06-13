package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class CountSegments {
    public static void main(String[] args) {
        System.out.println(countSegments("aa ff ff"));
        System.out.println(countSegments(" aa ff ff   "));
        System.out.println(countSegments("aa     "));
        System.out.println(countSegments(""));
        System.out.println(countSegments("   "));
        System.out.println(countSegments("weq"));


    }
    //不包含打印字符
    public static int countSegments(String s) {
        if(s == null || s.length() < 1)
            return 0;
        int count = 0;
        int start = 0;
        while (start < s.length()){
            while (start < s.length() && s.charAt(start)==' ')
                start++;
            if(start == s.length())
                break;
            while (start < s.length() && s.charAt(start)!=' ')
                start++;
            count++;
        }
        return count;
    }
}
