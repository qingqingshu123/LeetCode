import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/11.
 */
public class Generate {
    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <3 ; j++) {
                break;
            }
            System.out.println(11);
        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1)
            return res;
        for (int i = 0; i < numRows; i++) {
            int last  =1;

            List<Integer> ls = new ArrayList<>();
            ls.add(1);
            res.add(ls);
        }
        return res;
    }
}
