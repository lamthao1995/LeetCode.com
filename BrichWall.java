public class Solution {
    static int[] MAX;
    static int min;
    static HashMap s;
    public int leastBricks(List<List<Integer>> wall) {
        s = new HashMap<Integer, Integer>();
        min = 0;   
        do_task(wall);
        return wall.size() - min;
        
    }
     public static void do_task(List<List<Integer>> test){
        ArrayList<Integer> t = (ArrayList<Integer>) test.get(0);
        int n = test.size();
        int SUM = 0;
        
        for(int i = 0; i < t.size(); i++) SUM = SUM + t.get(i);
       // System.out.println("SUM = " + SUM);
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = (ArrayList<Integer>) test.get(i);
            int sum = 0;
            for(int j = 0; j < temp.size(); j++){
                sum = sum + temp.get(j);
                if(s.containsKey(sum)){
                   int value = (Integer)s.get(sum) + 1;
                   s.replace(sum, value);
                }else{
                     s.put(sum, 1);
                }
                int val = (Integer)s.get(sum);
                if(min < val && sum != SUM) min = val;
            }
        }
    }
}