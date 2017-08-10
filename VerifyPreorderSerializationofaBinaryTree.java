public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack();
        String[] arr = preorder.split(",");
        int degree = -1;
        for(int i = 0; i < arr.length; i++){
            degree++;
            if(degree > 0)
                return false;
            if(arr[i].equals("#") == false)
                degree -= 2;
        }
        return degree == 0;
    }
}