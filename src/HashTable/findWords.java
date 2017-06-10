package HashTable;

/**
 * Created by jixiaoqiang on 2017/6/9.
 */
public class findWords {
    public String[] findWords(String[] words) {
        String[] res = new String[words.length];
        int index = 0;
        int [] alphabet ={2,3,3,2,1,2,2,   2,1,2,2,2,3,3,  1,1,1,1,2,1,  1,3,1,3,1,3};
        for(int i = 0; i < words.length; i++){
            boolean isInOneLine = true;
            String word = words[i].toUpperCase();
            for(int j = 0; j < word.length() -1; j++){
                if((alphabet[word.charAt(j)-'A']) != (alphabet[word.charAt(j+1) -'A'])){
                    isInOneLine = false;
                    break;
                }
            }
            if(isInOneLine){
                res[index++] = words[i] ;
            }
        }
        String[] res1 = new String[index];
        for(int i =0; i < index; i++){
            res1[i] = res[i];
        }
        return res1;
    }
}
