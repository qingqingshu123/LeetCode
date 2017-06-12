package CodeM.First; /**
 * Created by jixiaoqiang on 2017/6/12.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] voice1 = new int [n1];
        for(int i = 0; i < n1; i++){
            voice1[i] = in.nextInt();
        }

        int n2 = in.nextInt();
        int[] voice2 = new int [n2];
        for(int i = 0; i < n2; i++){
            voice2[i] = in.nextInt();
        }
        long minDiff = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i <=n2 - n1; i++) {
            for (int j = 0; j < n1 ; j++) {
                minDiff +=(voice1[j] - voice2[i + j]) * (voice1[j] - voice2[i+j]);
                if(minDiff > Long.MAX_VALUE - 1000 *1000)
                    break;
            }
            res =Math.min(minDiff,res);
            minDiff = 0;
        }
        System.out.println(res);
    }
}