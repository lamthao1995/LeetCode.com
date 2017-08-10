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
    int pIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || postorder.length != inorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        pIndex = inorder.length - 1;
        return buildTree(inorder, postorder, map, 0, inorder.length - 1);
        
    }
    private TreeNode buildTree(int[] in, int[] post, 
                               HashMap<Integer, Integer> map, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        TreeNode node = new TreeNode(post[pIndex--]);
        if(inStart == inEnd) return node;
        int iIndex = map.get(node.val);
        node.right = buildTree(in, post, map, iIndex + 1, inEnd);
        node.left = buildTree(in, post, map, inStart, iIndex - 1);
        return node;
    }
}