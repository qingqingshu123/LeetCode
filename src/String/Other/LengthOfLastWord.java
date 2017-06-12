package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord("      "));
        System.out.println(lengthOfLastWord(" a "));
        System.out.println(lengthOfLastWord("a    "));

        System.out.println(lengthOfLastWord("afvb ddd  dd "));
        System.out.println(lengthOfLastWord("adaddd"));
        System.out.println(lengthOfLastWord(" a  v  dd"));
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() < 1)
            return 0;

        int end = s.length() - 1;;
        while (end >=0 && s.charAt(end) == ' '){
            end --;
        }
        if(end < 0){
            if(s.charAt(0) == ' ')
                return 0;
            else
                return s.length();
        }
        int start = end-1;
        while (start >=0 && s.charAt(start) != ' '){
            start--;
        }
        return end - start;
    }
}
