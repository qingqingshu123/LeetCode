package String;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }

    public static String addBinary(String a, String b) {
        if(a == null || a.length() < 1)
            return b;
        if(b == null || b.length() < 1)
            return a;
        int c = 0;
        int bit = 0;
        int ai = 0, bi = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >=0){
            ai = (i>=0)? a.charAt(i) -'0' : 0;
            bi = (j>=0)? b.charAt(j) -'0' : 0;
            int tmp =ai + bi + c;
            bit = tmp% 2;
            c = tmp>1 ? 1 : 0;
            sb.insert(0, bit);
            //System.out.println(sb.toString());
            i--;
            j--;
        }
        if(c != 0)
            sb.insert(0,'1');
        return sb.toString();
    }

}
