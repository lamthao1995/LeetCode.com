public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack();
        int i = 0;
        int len = heights.length;
        int max_area = 0; // Initalize max area
        int tp;  // To store top of stack
        int areaMax; 
        while(i < len){
            if(s.isEmpty() || heights[s.peek()] < heights[i]){
                s.push(i++);
            }else{
                tp = s.pop();
                areaMax = heights[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
                if(areaMax > max_area){
                    max_area = areaMax;
                }
            }
        }
        while(!s.isEmpty()){
            tp = s.pop();
            areaMax = heights[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
            if(areaMax > max_area){
                max_area = areaMax;
            }
        }
        return max_area;
    }
}