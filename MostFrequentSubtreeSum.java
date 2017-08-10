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
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> rs = new ArrayList<>();
        sum(map, root);
        for(Map.Entry<Integer, Integer> me : map.entrySet()){
            if(me.getValue() == max){
                rs.add(me.getKey());
            }
        }
       // System.out.print(max);
        return rs.stream().mapToInt(i -> i).toArray();
    }
    public int sum(Map<Integer, Integer> map, TreeNode root){
        if(root == null) return 0;
        int left = sum(map, root.left);
        int right = sum(map, root.right);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}