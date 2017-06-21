package Other;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        if(num ==0)
            return "0";
        boolean isNegative = false;
        if(num < 0)
            isNegative = true;
        int tmp = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while(tmp > 0){
            sb.insert(0,tmp%7);
            tmp /=7;
        }
        if(isNegative)
            sb.insert(0,'-');
        return sb.toString();
    }
}
