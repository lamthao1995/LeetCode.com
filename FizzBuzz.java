public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> arr = new ArrayList<>();
        if(n <= 0)
            return arr;
        for(int i = 1; i <= n; i++){
            if(i % 15 ==0){
                arr.add("FizzBuzz");
            }else if(i % 3 == 0){
                arr.add("Fizz");
            }else if(i % 5 == 0){
                arr.add("Buzz");
            }else{
                arr.add(i + "");
            }
        }
        return arr;
    }
}