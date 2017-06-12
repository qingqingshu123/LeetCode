package String.Reverse;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class ReverseStr {
    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        if(s == null)
            return null;
        StringBuilder sb = new StringBuilder();
        int leftLen = s.length();
        int startIndex = 0;
        while (leftLen > 0){
            if(leftLen >= 2*k){
                reverseString(s, startIndex, k, sb);
                for (int i = startIndex + k; i <startIndex+2*k; i++) {
                    sb.append(s.charAt(i));
                }
                leftLen -= 2*k;
                startIndex += 2*k;
            }else if(leftLen >= k){
                reverseString(s, startIndex, k, sb);
                for (int i = startIndex + k; i <startIndex+leftLen; i++) {
                    sb.append(s.charAt(i));
                }
                leftLen = 0;
            }else{
                reverseString(s, startIndex, leftLen, sb);
                leftLen = 0;
            }
        }
        return sb.toString();
    }

    private void reverseString(String str, int s, int len, StringBuilder sb){
        for(int i = s+len -1; i >=s; i--){
            sb.append(str.charAt(i));
        }
    }
}
