package String;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class CheckRecord {
    public static void main(String[] args) {
//        System.out.println(checkRecord("PPALLP"));
//        System.out.println(checkRecord("PPALLL"));
//        System.out.println(checkRecord("LALL"));


        System.out.println(checkRecord2(1));
        System.out.println(checkRecord2(2));
        System.out.println(checkRecord2(3));
        System.out.println(checkRecord2(4));
        System.out.println(checkRecord2(5));
        System.out.println(checkRecord2(100));
    }
    public static boolean checkRecord1(String s) {
        if(s == null || s.length() < 1)
            return true;
        int late = 0;
        int absent = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'A':
                    absent++;
                    break;
                case  'L':
                    late++;
                    break;
                default:
                    break;
            }
        }
//        System.out.println(late);
//        System.out.println(absent);
        return (absent>1  ||s.indexOf("LLL")>-1 ) ? false : true;
    }

    public static boolean checkRecord1_1(String s) {
        if(s == null || s.length() < 1)
            return true;
        int absent = 0;
        for (int i = 0; i < s.length(); ) {
            if(s.charAt(i) == 'A'){
                absent++;
                if(absent > 1)
                    return false;
                i++;
            }
            else if(s.charAt(i) =='L'){
                int start = i;
                while (i< s.length() && s.charAt(i)=='L'){
                    if(i - start + 1> 2)
                        return false;
                    i++;
                }
            } else {
                i++;
            }

        }
        return  true;
    }

    //概率题
    public static int checkRecord2(int n) {
        if(n < 1)
            return 0;
        if(n == 1)
            return 3;
        if(n == 2)
            return 8;
        if(n == 3)
            return 19;
        //Cn 2*3^(n-2)+Cn-2 1（2^(n-3) +　(n-3)*2^(n-4)）  有重复
        return 3^n - n*(n-1)/2 * 3^(n-2)
                -(2^(n-2));
    }
}
