import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/11.
 */
public class Generate {
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
