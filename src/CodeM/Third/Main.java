package CodeM.Third;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, String > map =new HashMap<>();
        boolean isHasResult = false;
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();
            if(m == 0){
                System.out.println(-1);
                continue;
            }
            System.out.println(m);
            isHasResult = false;
            for (int i = 0; i < m; i++) {
                String s = new String();
                if(in.hasNext()){
                    if(isHasResult)
                        continue;
                    s = in.next();
                }
                System.out.println(s);
                String[] arr = s.split(" ");
                System.out.println(arr.length + "!!!!!!!!!!!!!");
                if(arr[0].equals("?"))
                    continue;
                else{
                    int id = Integer.parseInt(arr[1]);
                    String method = arr[0];
                    if(map.containsKey(id)){
                        if(map.get(id).equals("I")){
                            System.out.println(i+1);
                            isHasResult = true;
                        }
                        else if(map.get(id).equals("O")){
                            map.remove(id);
                            continue;
                        }
                    }
                    else
                        map.put(id,method);
                }
            }
            if(!isHasResult)
                System.out.println(-1);
        }
    }
}