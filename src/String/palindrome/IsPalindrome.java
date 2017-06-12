package String.palindrome;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class IsPalindrome {
    //回文
    public static void main(String[] args) {
        System.out.println(isPalindrome("ada"));
        System.out.println(isPalindrome("adad,"));
        System.out.println(isPalindrome("    "));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("123"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    //没有考虑到数字
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() <2)
            return true;
        StringBuilder res = new StringBuilder(s.toLowerCase());
        int start = 0;
        int end = res.length() - 1;
        while (start < end){

            while (start < end && !Character.isAlphabetic(res.charAt(start))&& !Character.isDigit(res.charAt(start)))
                start++;
            while (start < end && !Character.isAlphabetic(res.charAt(end))&& !Character.isDigit(res.charAt(end)))
                end--;
            if(start < end ){
                if(res.charAt(start) == res.charAt(end)){
                    start++;
                    end--;
                } else
                    return false;
            }
        }
        return true;
    }
}
