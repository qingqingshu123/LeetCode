package Arrays.CircleDo;

/**
 * Created by jixiaoqiang on 2017/6/11.
 */
public class Rotate {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(arr);
    }
    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length < 1)
            return;
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tC < dC){
            for(int i = tC; i < dC; i++){
                //这部分要考虑完整
                int tmp = matrix[tR][i];
                matrix[tR][i] = matrix[dR+tC-i][tR];
                matrix[dR+tC-i][tR] = matrix[dR][dR+tC-i];
                matrix[dR][dR+tC-i] = matrix[i][dR];
                matrix[i][dR] = tmp;
                for(int k = 0; k <=3; k++){
                    for(int j = 0; j <=3; j++){
                        System.out.print(matrix[k][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println();

            }
            tC++;
            tR++;
            dR--;
            dC--;
        }

    }
}
