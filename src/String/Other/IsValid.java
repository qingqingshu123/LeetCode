package String.Other;

import java.util.LinkedList;

/**
 * Created by jixiaoqiang on 2017/6/13.
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid(""));
        System.out.println(isValid("  "));
        System.out.println(isValid(" {}"));
        System.out.println(isValid("{{()}}"));


    }
    public static boolean isValid(String s) {
        if(s == null || s.length() < 1)
            return true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) =='(' || s.charAt(i) =='{' || s.charAt(i) =='[')
                stack.push(s.charAt(i));
            else {
                if(!stack.isEmpty()){
                    switch (s.charAt(i)){
                        case ')':
                            if(stack.pop() == '(')
                                continue;
                            return false;
                        case ']':
                            if(stack.pop() == '[')
                                continue;
                            return false;
                        case '}':
                            if(stack.pop() == '{')
                                continue;
                            return false;
                        default:
                            return false;
                    }
                }
                else
                    return false;
            }
            //System.out.println(stack.size());
        }
        return stack.size() == 0 ? true : false;
    }
}
