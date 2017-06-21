package Other;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        int tmp = n;
        while (tmp > 0){
            char c = (tmp%26 == 0) ? 'Z':(char)(((tmp%26)-1)+'A');
            res.insert(0, c);
            if(tmp == 26)
                break;
            if(tmp % 26 == 0)
                tmp=tmp/26-1;
            else
                tmp/=26;
        }
        return res.toString();
    }
}
