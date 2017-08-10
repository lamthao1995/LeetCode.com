public class Solution {
   
    int[] trace = new int[128];
    int[] temp = new int[128];
    public boolean checkInclusion(String s1, String s2) {
        int lenOfS1 = s1.length();
        int lenOfS2 = s2.length();
        if(lenOfS1 > lenOfS2) return false;
        
        for(int i = 0; i < lenOfS1; i++){
             trace[(int)s1.charAt(i)]++;
             temp[(int)s1.charAt(i)]++;
        }
      
        for(int i = 0; i <= lenOfS2 - lenOfS1; i++){
            int sum = 0;
            for(int j = 0; j < lenOfS1; j++){
                sum += trace[(int)s2.charAt(i + j)];
                trace[(int)s2.charAt(i + j)]--;
            }
             System.out.println("sum = " + sum +" and i = " + i);
            if(sum == s1.length()) return true;  
            else {
                for(int k = 0; k < temp.length; k++) trace[k] = temp[k];
            }
           
        }
        return false;
    }
}