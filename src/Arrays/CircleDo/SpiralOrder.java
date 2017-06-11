package Arrays.CircleDo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/11.
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ls = new ArrayList<>();
        if(matrix == null || matrix.length ==0 || matrix[0].length ==0)
            return ls;
        int m =Math.min(matrix.length,matrix[0].length);
        int start = 0;
        int row = 0;
        int col = 0;
        //这个规律要发现  迭代 一圈圈进行
        //while(start * 2 < matrix.length && start * 2 < matrix[0].length)
        while(start * 2 < m){
            row = matrix.length - start -1;
            col =matrix[0].length - start -1;
            //考虑最后的特殊情况
            /*
             1.  1 2 3   2. 1    3.1 2
                 6 5 4      2
                            3
              加入限制条件
              上一个约束是下一个约束的前提
             */
            //上
            for(int i = start; i <= col; i++){
                ls.add(matrix[start][i]);
            }
            //右
            if(start < row ){
                for(int i = start+1; i <=row; i++){
                    ls.add(matrix[i][col]);
                }

            }
            //下
            if(start < row && start < col){
                for(int i = col - 1; i >= start; i--){
                    ls.add(matrix[row][i]);
                }
            }

            //左
            if(start < row-1 && start < col){
                for(int i = row - 1; i > start; i--){
                    ls.add(matrix[i][start]);
                }
            }

            start++;
        }
        return ls;

    }


    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n < 1)
            return res;
        //坐标形式 对角线上的两个坐标
        int tR = 0;
        int tC = 0;
        int dR = n - 1;
        int dC = n - 1;
        int count = 1;

        while (tR <= dR && tC <= dC){
            int curR = tR;
            int curC = tC;
            //特殊情况
            if(tR == dR && tC== dC){
                res[tR][tC] = count++;
            }else {
                while (curC != dC)
                    res[curR][curC++] = count++;
                while (curR != dR)
                    res[curR++][curC] = count++;
                while (curC != tC)
                    res[curR][curC--] = count++;
                while (curR != tR)
                    res[curR--][curC] = count++;
            }
            tC++;
            tR++;
            dC--;
            dR--;
        }
        return res;
    }
}
