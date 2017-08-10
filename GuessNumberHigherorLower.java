/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long start = 1, end = n;
        while(start <= end){
            long mid = (start + end) / 2;
            int rs = guess((int)mid);
            if(rs == 0){
                return (int)mid;
            }else if(rs == 1){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}