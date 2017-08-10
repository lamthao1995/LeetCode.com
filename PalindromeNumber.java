public class Solution {
    public boolean isPalindrome(int x) {
      if(x < 0) return false;
      if(x == 0) return true;
      if(x % 10 == 0) return false;
      int res = 0;
      while(x > res){
          res = res * 10 + x % 10;
          x = x / 10;
      }
     if (x == res || x == res / 10) return true;
     else return false;
       
    }
   
}