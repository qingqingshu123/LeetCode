package Arrays.Other;

/**
 * Created by jixiaoqiang on 2017/6/5.
 */
public class PlusOne {
    public static void main(String[] args) {

    }
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length <= 0)
            return null;
        int flag = 0;
        for(int i = digits.length-1; i >= 0; i--){
            int num = digits[i] +  flag;
            if(i == digits.length -1)
                num += 1;
            if(num > 9){
                digits[i] = 0;
                flag = 1;
            }
            else{
                flag = 0;
                digits[i] = num;
                return digits;
            }
        }
        int[] arr = new int[digits.length + 1];
        if(flag == 1){
            arr[0] = 1;
            for(int i = 1; i < arr.length; i++){
                arr[i] = digits[i-1];
            }
        }
        return arr;
    }
}
