/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    long min = Long.MIN_VALUE;
    int minC = 0;
    int counter = 1;
    HashMap<Integer, List<Integer>> s = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        traversing(root);
        List<Integer> tmp = s.get(minC);
        System.out.println(minC);
        int[] result = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            result[i] = tmp.get(i);
        }
        return result;
    }
    public void traversing(TreeNode root){
        if(root == null) return;
        traversing(root.left);
        if((long)root.val != min){
               if(s.containsKey(counter)){
                   List<Integer> t = s.get(counter);
                   t.add((int)min);
                   s.put(counter, t);
               }else{
                   List<Integer> t = new ArrayList<>();
                   t.add((int)min);
                   s.put(counter, t);
               }
                minC = minC > counter ? minC : counter;
                counter = 1;
            min = (long)root.val;
        }else{
            counter++;
        }
        traversing(root.right);
    }
}