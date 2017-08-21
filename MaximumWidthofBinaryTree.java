/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, int[]> map = new HashMap();
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        traverse(root, 0, 0);
        int maxDis = 1;
        for(int depth : map.keySet()){
            int[] indices = map.get(depth);
            maxDis = Math.max(maxDis, indices[1] - indices[0] + 1);
        }
        return maxDis;
        
    }
    public void traverse(TreeNode root, int index, int depth){
        if(root == null){
            return;
        }
        if(!map.containsKey(depth)){
            map.put(depth, new int[]{index, index});
        }
        int[] indices = map.get(depth);
        indices[0] = Math.min(indices[0], index);
        indices[1] = Math.max(indices[1], index);
        map.put(depth, indices);
        traverse(root.left, 2 * index, depth + 1);
        traverse(root.right, 2 * index + 1, depth + 1);
    }
}