package String;

/**
 * Created by jixiaoqiang on 2017/6/12.
 */
public class ComplexNumberMultiply {
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("2+3i","3+4i"));
    }
    //不支持单一 “1” 这样的输入
    public static String complexNumberMultiply(String a, String b) {
        int relA = 0;
        int virA = 0;
        int relB = 0;
        int virB = 0;

        String[] arr = a.split("\\+");
        relA = Integer.parseInt(arr[0]);
        virA = Integer.parseInt(new StringBuilder(arr[1]).delete(arr[1].length()-1, arr[1].length()).toString());

        arr = b.split("\\+");
        relB = Integer.parseInt(arr[0]);
        virB = Integer.parseInt(new StringBuilder(arr[1]).delete(arr[1].length()-1, arr[1].length()).toString());

        StringBuilder res = new StringBuilder();
        res.append((relA*relB - virA* virB) + "+");
        res.append((relA * virB + relB * virA) +"i");
        return res.toString();
    }
}
