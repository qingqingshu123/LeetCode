package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr1 ={"aaa","abb"};
        System.out.println(longestCommonPrefix(arr1));

        String[] arr2 ={" aaa","abb"};
        System.out.println(longestCommonPrefix(arr2));

        String[] arr3 ={"aaa"};
        System.out.println(longestCommonPrefix(arr3));

        String[] arr4 ={"aaa","abbdfsfsd"};
        System.out.println(longestCommonPrefix(arr4));

        String[] arr5 ={"vaaa","abb"};
        System.out.println(longestCommonPrefix(arr5));

        String[] arr6 ={""};
        System.out.println(longestCommonPrefix(arr6));

        String[] arr7 ={"" ,"dd"};
        System.out.println(longestCommonPrefix(arr7));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <1)
            return "";
        StringBuilder res = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(strs[i].length(),minLen);
        }
        for (int i = 0; i <minLen; i++) {
            char c= strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != c)
                    return res.toString();
            }
            res.append(c);
        }
        return res.toString();
    }
}
