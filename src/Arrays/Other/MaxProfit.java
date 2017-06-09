package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/8.
 */
public class MaxProfit {
    public static void main(String[] args) {

    }
    //如何减少空间复杂度
    //辅助数组当前i右边的最大值
    //只能交易一次
    //通过迭代更新 替换辅助数组
    public int maxProfit(int[] prices) {
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

    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int maxProfit = 0;
        int leftMin = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, Math.max(0, prices[i] - leftMin));
            leftMin = Math.min(leftMin, prices[i]);
        }
        return maxProfit;
    }

    //可以交易多次//买入交易点为极小值点 卖出交易点为极大值点
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int maxProfit = 0;
        int buyin = -1;
        int sellout = -1;
        if(prices[0] < prices[1]){
            buyin = 0;
        }
        for(int i = 1; i < prices.length-1; i++){
            if(buyin < 0){
                if(prices[i-1] >= prices[i] && prices[i] < prices[i+1]){
                    buyin = i;
                }
            }
            if(buyin > -1 && sellout < 0){
                if(prices[i] > prices[i+1]){
                    sellout = i;
                }
            }
            if(buyin > -1 && sellout > buyin){
                maxProfit += prices[sellout] - prices[buyin];
                buyin =-1;
                sellout =-1;
            }
        }
        if(buyin > -1 && sellout < 0){
            if(prices[prices.length-2] <= prices[prices.length-1]){
                maxProfit += prices[prices.length-1] - prices[buyin];
            }
        }
        return maxProfit;
    }

    //最多可以交易2次  辅助数组 以i作为分界点左右两边收益的最大值
    // 主要解决找到一个区间最大收益的速率
    //[0 i]
    //(i len]
    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int[] helpLeft = new int [prices.length];
        int[] helpRight = new int [prices.length];
        int maxProfit = 0;
        int leftMin = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, Math.max(0, prices[i] - leftMin));
            leftMin = Math.min(leftMin,prices[i]);
            helpLeft[i] = maxProfit;
        }

        maxProfit = 0;
        int rightMax = prices[prices.length -1];
        for(int i = prices.length -2; i >= 0; i--){
            maxProfit = Math.max(maxProfit, Math.max(0,rightMax - prices[i]));
            rightMax = Math.max(rightMax,prices[i]);
            helpRight[i] = maxProfit;
        }
        maxProfit = 0;
        for(int i = 0; i < prices.length-2; i++){
            maxProfit = Math.max(helpLeft[i] + helpRight[i+1],maxProfit);
        }
        maxProfit = Math.max(helpLeft[prices.length -1],maxProfit);
        return maxProfit;
    }
}
