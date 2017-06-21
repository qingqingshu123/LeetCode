package Other;

/**
 * Created by jixiaoqiang on 2017/6/21.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        //词频统计
        // 重复
        //hashMap 也可以  排序
        int[] total = new int [26];
        for(int i = 0; i < t.length();i++){
            total[t.charAt(i)-'a']++;
        }
        for(int i = 0; i < s.length();i++){
            total[s.charAt(i)-'a']--;
        }
        int i = 0;
        for(i = 0; i< 26;i++){
            if(total[i] > 0)
                break;
        }
        return (char)('a'+i);
    }
}
