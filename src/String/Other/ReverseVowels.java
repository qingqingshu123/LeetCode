package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class ReverseVowels {
    public static void main(String[] args) {
//        System.out.println(reverseVowels("aeiou"));
//        System.out.println(reverseVowels(" afff fff "));
//        System.out.println(reverseVowels("addd ee"));
//        System.out.println(reverseVowels("dddaddd"));
//        System.out.println(reverseVowels("uoiea"));
        System.out.println(reverseVowels("leetcode"));
    }

    //a e i o u 元音字母
    //swap方法
    public static String reverseVowels(String s) {
        StringBuilder res = new StringBuilder(s);
        int start = 0;
        int end = res.length() -1;
        System.out.println(res.toString());
        while (start < end){
            while (start < end && !isVowels(res.charAt(start)))
                start++;
            while (start < end && !isVowels(res.charAt(end)))
                end--;
            System.out.println(start);
            System.out.println(end);
            if(start < end){
                char c = res.charAt(start);

                res.setCharAt(start, res.charAt(end));
                res.setCharAt(end, c);
                System.out.println(res.charAt(start));
                System.out.println(res.charAt(end));

                start++;
                end--;
            }
        }
        return res.toString();
    }
    private static boolean isVowels(char c){
        if(c=='a'|| c=='e' || c=='i'|| c=='o' ||c=='u'||
            c=='A' ||c=='E' || c=='I'|| c=='O' ||c=='U')
            return true;
        else
            return false;
    }
}
