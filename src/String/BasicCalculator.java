package String;

import java.util.LinkedList;

/**
 * Created by jixiaoqiang on 2017/6/16.
 */
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("2 + 1"));
        System.out.println(calculate("2 - 1  + 3"));
        System.out.println(calculate("1-3"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("()+(1)"));
        System.out.println(calculate("()+()"));
        System.out.println(calculate("(1-(3-4))"));
    }
    //对于stack queue 直接用自己定义的出入方式操作  addfirst pollfirst
    public static int calculate(String s) {
        if(s == null || s.length() < 1)
            return 0;
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
               // System.out.println(sb.toString());
                i++;
                if (i == s.length())
                    stack1.addLast(Integer.parseInt(sb.toString()));
            } else {
                if (sb.length() > 0) {
                    stack1.addLast(Integer.parseInt(sb.toString()));
                    sb.delete(0, sb.length());
                }
                if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    stack2.addLast(s.charAt(i));
                } else if (s.charAt(i) == '(') {
                    stack1.addLast(Integer.MIN_VALUE);  //这个实际也有问题
                } else if (s.charAt(i) == ')') {
                    boolean findLeft = false;
                    while (!findLeft) {
                        int v2 = stack1.pollLast();
                        if(v2 == Integer.MIN_VALUE) {
                            findLeft = true;//()这种情况
                            continue;
                        }
                        int v1 = stack1.pollLast();
                        if(v1 == Integer.MIN_VALUE){
                            findLeft = true;//(1)这种情况
                            stack1.addLast(v2);
                            continue;
                        }
                        if (stack1.peekLast() == Integer.MIN_VALUE) {
                            findLeft = true;
                            stack1.pollLast();
                        }
                        switch (stack2.pollLast()) {
                            case '+':
                                stack1.addLast(v1 + v2);
                                break;
                            case '-':
                                stack1.addLast(v1 - v2);
                                break;
                        }
                    }
                }else {   //空格
                    i++;
                    continue;
                }
                i++;
            }
        }
        if(stack1.size() == 0)  //()+()这种情况
            return 0;
        while (stack1.size()>1){  //queue
            int v1 = stack1.pollFirst();
            int v2 = stack1.pollFirst();
           // System.out.println(v1);
           // System.out.println(v2);
            switch (stack2.pollFirst()) {
                case '+':
                    stack1.addFirst(v1 + v2);
                    break;
                case '-':
                    stack1.addFirst(v1 - v2);
                    break;
            }
        }
        return stack1.pollLast();
    }

}
