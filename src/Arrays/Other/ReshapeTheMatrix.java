package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        //matrixReshape(arr,1,4);
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length <= 0 || nums[0].length <= 0)
            return null;
        int row = nums.length;
        int col = nums[0].length;
        int total = c * r;
        System.out.println(row);
        System.out.println(col);
        System.out.println(total);
        if(row * col == total){
            int[][] arr = new int[r][c];
            for(int i = 0; i < total; i++){
                arr[i/c][i%c] = nums[i/col][i%col];
            }
            return arr;
        }
        return  nums;
    }

}
