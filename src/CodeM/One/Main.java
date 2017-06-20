package CodeM.One;

import java.util.Scanner;

/**
 * Created by jixiaoqiang on 2017/6/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double v = in.nextDouble();
        double u = in.nextDouble();
        System.out.println(n);
        System.out.println(v);
        System.out.println(u);

        double[] c = new double[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextDouble();
        }
        double[] d = new double[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.nextDouble();
        }
        double sum = 0.0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                sum +=j*d[i];
            }
        }
        double speedAvr = sum /(double) n;
        System.out.println(speedAvr);
        double speedAvr1 = 0.0;
        for (int i = 0; i < n; i++) {
            speedAvr1 += c[i];
        }
        speedAvr = speedAvr1 -speedAvr;
        System.out.println(speedAvr);
        speedAvr = speedAvr/(double)n -v;
        System.out.println(speedAvr);
        double avr = 0.0;
        avr = n*n*u/speedAvr;
//        for (int i = 0; i < n; i++) {
//            avr+= n*u /(c[i] - v - ((double)(n-1))/2*d[i]);
//        }
        System.out.printf("%.3f", avr);
    }
}
