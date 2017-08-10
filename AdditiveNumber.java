public class Solution {
    static long[] root = new long[22];
    static String input = "";
    static int n;
    static int index = 0;
    static boolean check = false;
    public boolean isAdditiveNumber(String num) {
        check = false;
        if(num == null || num.length() < 3) return false;
        input = num.trim();
        n = input.length();
        System.out.println("n = " + n +" and string: " + input);
        backTrackAddictiveNumber(1);
        return check;
    }
    
    public static void backTrackAddictiveNumber(int k){
        for(int i = 1; i <= n - index; i++){
            if(check == true) return;
            if(input.substring(index ,index + i).charAt(0) == '0' && i >= 2) break;
                 int temp = index;
           // if(input.charAt(temp) != '0') continue;
                try {
                    root[k] = Long.parseLong(input.substring(index ,index + i));
                } catch (NumberFormatException e) {
                  
                    System.err.println("error : " + input.substring(index ,index + i));
                    break;
                }
           
            index = index + i;
            if(index == n && isAddictive(k)) {
                check = true;
                System.out.println("check = " + check);
                return;
            }else{
                if(k < 20) backTrackAddictiveNumber(k + 1);
            }
            root[k] = 0;
            index = temp;
            
           
        }
    }
    public static boolean isAddictive(int k){
        if(k < 3) return false;
        //System.out.println("Arrays: " + Arrays.toString(root));
        for(int i = 1; i < k - 1; i++){
            if((root[i] + root[i + 1]) != root[i + 2]) {
             //   System.out.println("Vao false");
                return false;
            }
        }
        return true;
    }
}