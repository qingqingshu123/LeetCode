package Arrays.Other;
import java.util.*;


/**
 * Created by jixiaoqiang on 2017/6/7.
 */


class Interval {//没有实现Comparable
    int start;
    int end;
    public Interval() { start = 0; end = 0; }
    public Interval(int s, int e) { start = s; end = e; }
}

public class Merge {
    public static void main(String[] args) {
        List<Interval> ls = new ArrayList<>();
        ls.add(new Interval(1,1));
        ls.add(new Interval(2,3));
        ls.add(new Interval(4,5));
        ls.add(new Interval(6,8));
        ls.add(new Interval(22,222));

        new Merge().merge(ls);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null)
            return null;
        List<Interval> ls = new ArrayList<>();
        if(intervals.size() <= 0)
            return ls;
        //intervals.sort();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }else{
                    return o1.start - o2.start;
                }

            }
        });
        System.out.println(intervals);
        //intervals.sort(new IntervalComparator());
        Iterator<Interval> iterator = intervals.iterator();
        int start = 0;
        int end = 0;
        if(iterator.hasNext()){
            Interval item = iterator.next();
            start = item.start;
            end = item.end;
        }
        while(iterator.hasNext()){
            Interval item = iterator.next();
            if(end >= item.start) {
                end = Math.max(item.end,end);
            }
            else {
                ls.add(new Interval(start, end));
                start = item.start;
                end =item.end;
            }
        }
        ls.add(new Interval(start, end));
        return ls;
    }
}

class  IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        if(o1.start == o2.start){
            //为什么 ？1：-1 不通过？？ leetcode
            return o1.end <= o2.end ? -1: 1;
        }else{
            return o1.start < o2.start ?-1: 1;
        }
    }
}


