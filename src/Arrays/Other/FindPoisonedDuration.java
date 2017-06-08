package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class FindPoisonedDuration {
    public static void main(String[] args) {

    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length <= 0)
            return 0;
        int totalTime = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if(timeSeries[i+1] - timeSeries[i] >= duration)
                totalTime += duration;
            else
                totalTime += timeSeries[i+1] - timeSeries[i];
        }
        return  totalTime;
    }
}
