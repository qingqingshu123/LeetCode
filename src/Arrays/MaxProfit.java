package Arrays;

/**
 * Created by jixiaoqiang on 2017/6/8.
 */
public class MaxProfit {
    public static void main(String[] args) {

    }
    //如何减少空间复杂度
    //辅助数组当前i右边的最大值
    //只能交易一次
    public int maxProfit1(int[] prices) {
        int [] helpr  = new int[prices.length + 1];
        int max = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length; i > 0  ; i--) {
            max = Math.max(max, prices[i-1]);
            helpr[i] = max;
        }
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(helpr[i+1] - prices[i], maxProfit);
        }
        return maxProfit < 0 ? 0: maxProfit;
    }

    //可以交易多次
    public int maxProfit2(int[] prices) {
        int [] helpr  = new int[prices.length + 1];
        int max = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length; i > 0  ; i--) {
            max = Math.max(max, prices[i-1]);
            helpr[i] = max;
        }
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(helpr[i+1] - prices[i], maxProfit);
        }
        return maxProfit < 0 ? 0: maxProfit;
    }

    //最多可以交易2次
    public int maxProfit3(int[] prices) {
        int [] helpr  = new int[prices.length + 1];
        int max = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = prices.length; i > 0  ; i--) {
            max = Math.max(max, prices[i-1]);
            helpr[i] = max;
        }
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(helpr[i+1] - prices[i], maxProfit);
        }
        return maxProfit < 0 ? 0: maxProfit;
    }
}
