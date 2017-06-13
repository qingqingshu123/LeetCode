package String.SubString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class LetterCombinations {
    public static void main(String[] args) {
        for(String i :letterCombinations("23156"))
            System.out.println(i);
    }
    //队列的思想  树分层打印思想
    public static List<String> letterCombinations(String digits) {
        String [] s = {"","","abc","def","ghi","jkl","mno",
                "pqrs","tuv","wxyz"};
        LinkedList<String> queue = new LinkedList<>();
        if(digits == null || digits.length() < 1)
            return queue;
        int dequeueNum = 1;
        int index = 0;
        StringBuilder sb;
        boolean first = true;
        int k = 0;
        String c;
        while(k < digits.length()){
            index = (int)(digits.charAt(k)-'0');
            //System.out.println(index);
            if(index == 0 || index == 1)
                return new ArrayList<String>();
            //System.out.println(dequeueNum);
            for (int i = 0; i < dequeueNum; i++) {
                if(first){
                    c ="";
                    first = false;
                }else{
                    c = queue.pollFirst();
                }
                for (int j = 0; j < s[index].length(); j++) {
                        sb = new StringBuilder(c);
                        sb.append(s[index].charAt(j));
                        queue.addLast(sb.toString());

                }
            }
            dequeueNum = dequeueNum * s[index].length();
            k++;
        }
        //System.out.println(queue.size());
        return queue;
    }
}
