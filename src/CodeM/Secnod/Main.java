package CodeM.Secnod;

import java.util.Scanner;
//2 超时
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mark = in.nextInt();
        int countLess = 0;
        int countMore = 0;
        for(int i = 0; i < n -1; i++){
            if(mark >= in.nextInt())
                countLess++;
        }
        countMore = n - 1 - countLess;
        int aliveNum = 0;
        while(countLess > 0){
            aliveNum++;
            int miunte = countMore>>1;
            countLess = countLess - ((countMore + countLess + 1) >> 1) + miunte;
            countMore = countMore -miunte;
        }
        System.out.println(aliveNum);
    }
}