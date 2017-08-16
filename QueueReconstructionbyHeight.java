public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> rs = new LinkedList<>();
        for(int[] cur : people){
            rs.add(cur[1], cur);
        }
        return rs.toArray(new int[people.length][]);
    }
}
 // Arrays.sort(people,new Comparator<int[]>(){
 //           @Override
 //           public int compare(int[] o1, int[] o2){
 //               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
 //           }
 //        });
 //        List<int[]> res = new LinkedList<>();
 //        for(int[] cur : people){
 //            res.add(cur[1],cur);       
 //        }
 //        return res.toArray(new int[people.length][]);