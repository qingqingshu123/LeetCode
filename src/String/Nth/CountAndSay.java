package String.Nth;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class CountAndSay {
    public static void main(String[] args) {
        countAndSay(1);
        countAndSay(2);
        countAndSay(3);
        countAndSay(4);
        countAndSay(5);
    }
    //类似双指针的思想  迭代前一个结果作为下一个的输入
    public static String countAndSay(int n) {
        String res ="1";
        for (int i = 1; i < n; i++) {
            res = geneNext(res);
            //System.out.println(res);
        }
        System.out.println(res);
        return res;
    }

    private static String geneNext(String s){
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int i= 0;
        while (i < s.length()){
            if(s.charAt(start) == s.charAt(i))
                i++;
            else {
                sb.append(i-start).append(s.charAt(start));
                start = i;
            }
            if(i == s.length()){
                sb.append(i-start).append(s.charAt(start));
                //start = i;
            }
        }
        return sb.toString();
    }
}
