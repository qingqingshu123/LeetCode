package String.Reverse;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class ReverseString {
    public static void main(String[] args) {

    }

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
