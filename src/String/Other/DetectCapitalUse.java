package String.Other;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class DetectCapitalUse {
    public static void main(String[] args) {
        //System.out.println(detectCapitalUse("adc"));true

        //System.out.println(detectCapitalUse("ABC")); true

        //System.out.println(detectCapitalUse("Adc"));  true

        //System.out.println(detectCapitalUse("a"));true

        //System.out.println(detectCapitalUse("A"));true

        //System.out.println(detectCapitalUse("ad"));true

        //System.out.println(detectCapitalUse(""));true

        System.out.println(detectCapitalUse(" "));

        System.out.println(detectCapitalUse("  "));

        //System.out.println(detectCapitalUse("adW")); false
    }
    public static boolean detectCapitalUse(String word) {
        if(word == null)
            return false;
        if(word.length()==0)
            return true;
        if(word.length()==1){
            if(word.charAt(0) != ' ')
                return true;
            else
                return false;
        }
        int size = 0;  //1 全大写 2全小写 3 首大写，其余小写
        Character c0 = word.charAt(0);
        Character c1 = word.charAt(1);
        if(Character.isUpperCase(c0)){
            if(Character.isUpperCase(c1))
                size = 1;
            else
                size = 3;
        }
        else if(Character.isLowerCase(c1))
            size = 2;
        else
            return false;
        for (int i = 2; i <word.length(); i++) {
            switch (size){
                case 1:
                    if(Character.isUpperCase((word.charAt(i))))
                        break;
                    else
                        return false;
                case 2:
                case 3:
                    if(Character.isLowerCase((word.charAt(i))))
                        break;
                    else
                        return false;
            }
        }
        return true;
    }
}
