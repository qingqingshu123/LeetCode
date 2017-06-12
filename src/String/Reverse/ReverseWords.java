package String.Reverse;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s ="ac df eg";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords3(String s) {
        if(s == null)
            return null;
        StringBuilder sb = new StringBuilder();
        StringBuilder seq = new StringBuilder();
        seq.append(' ');
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) != ' ')
                seq.append(s.charAt(i));
            else{
                if(seq.length() > 1)
                    sb.insert(0,seq);
                seq.delete(0, seq.length());
                seq.append(' ');
            }
        }
        if(seq.length() > 1)
            sb.insert(0,seq);
        sb.delete(0, 1);
        return sb.toString();
    }


    public static String reverseWords(String s) {
        if(s == null)
            return null;
        String str = reverseWords3(s);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
