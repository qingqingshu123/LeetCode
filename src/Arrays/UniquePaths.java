package Arrays;

/**
 * Created by jixiaoqiang on 2017/6/6.
 */
public class UniquePaths {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int count = 0;
        if(m == 1 || n == 1)
            return 1;
        return uniquePaths(--m, n) + uniquePaths(m, --n) + 2;
    }
}
