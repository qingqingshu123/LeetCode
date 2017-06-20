package Niuke;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jixiaoqiang on 2017/6/16.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(k<1 || n<1 || k>n) System.out.println(0);
        int sum = 0;
        for (int i = n-1; i > n-k-1; i--) {
            sum+=i;
        }
        long res = 0;
        for (int i = n; i < sum; i+=n) {
            // 用于保存所有结果
            List<List<Integer>> result = new LinkedList<>();
            // 用于保存中间结果
            List<Integer> list = new LinkedList<>();
            // 条件满足就进行解题操作
            if (k > 0 && k <= n-1) {
                solve(k, 1, i, 0, list, result,n);
            }

            // 返回结果
           res += result.size();
        }
        System.out.println(res % 1000000007);
    }


    /**
     * 求解方法
     *
     * @param k         每个解的元素个数
     * @param cur       当前处理第k个元素
     * @param remainder k - cur + 1个元素的和
     * @param prevVal   第cur-1个元素的取值
     * @param list      将解的元素的集合类
     * @param result    保存所有结果的容器
     */
    public static void solve(int k, int cur, int remainder, int prevVal, List<Integer> list, List<List<Integer>> result, int n) {
        // 处理最后一个元素
        if (cur == k) {
            // remainder为最后一个解元素的值，它必须大于前一个解元素的值，并且不能超出9
            if (remainder > prevVal && remainder <= n-1) {
                // 添加元素值
                list.add(remainder);

                // 拷贝结果到新的队列中
                List<Integer> one = new LinkedList<>();
                for (Integer i : list) {
                    one.add(i);
                }

                // 保存结果
                result.add(one);
                // 删除最后一个元素，进行现场还原
                list.remove(list.size() - 1);
            }
        }
        // 不是最后一个元素
        else if (cur < k){
            for (int i = prevVal + 1; i <= n-1 - (k - cur); i++) {
                // 添加元素
                list.add(i);
                // 递归求解
                solve(k, cur + 1, remainder - i, i, list, result, n);
                // 现场还原
                list.remove(list.size() - 1);

            }
        }
    }
}

