public class Solution {
    public boolean isReflected(int[][] points) {
        if(points.length == 0)
            return true;
        Set<Integer> set = new HashSet<>();
        //y >= 0
        List<Integer> posY = new ArrayList<>();
        List<Integer> negY = new ArrayList<>();
        int counter = 0;
        for(int[] p : points){
            if(p[1] < 0)
                negY.add(counter);
            else
                posY.add(counter);
            counter++;
        }
        for(int index : posY){
            if(set.contains(points[index][1]))
                return true;
            set.add(points[index][1]);
        }
        set.clear();
        for(int index : negY){
            if(set.contains(points[index][1]))
                return true;
            set.add(points[index][1]);
        }
        return false;
        
    }
}