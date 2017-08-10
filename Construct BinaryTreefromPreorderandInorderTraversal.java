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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null 
           || inorder.length != preorder.length)
            return null;
        int len = inorder.length;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < len; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, preorder, 0, len - 1, map);
        
    }
    private TreeNode buildTree(int[] in, int[] pre, int inStart, int inEnd,
                              HashMap<Integer, Integer> map){
        if(inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(pre[preIndex++]);
        if(inStart == inEnd) return node;
        int inIndex = map.get(node.val);
        node.left = buildTree(in, pre, inStart, inIndex - 1, map);
        node.right = buildTree(in, pre, inIndex + 1, inEnd, map);
        return node;
    }
}