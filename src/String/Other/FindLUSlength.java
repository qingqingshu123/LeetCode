package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/22.
 */
public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }
}