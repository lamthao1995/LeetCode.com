public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++){
            if(i == 0 || i == numRows - 1){
                for(int j = i; j < len; j += step){
                    sb.append(s.charAt(j));
                }
            }else{
                boolean flag = true;
                int j = i;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while(j < len){
                    sb.append(s.charAt(j));
                    if(flag){
                        j = j + step1;
                    }else{
                        j = j + step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }
}