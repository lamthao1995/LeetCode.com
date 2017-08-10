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
    HashMap<Integer, Integer> map = new HashMap();
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        return construct(nums, 0, nums.length - 1);    
    }
    public TreeNode construct(int nums[], int left, int right){
        if(left > right)
            return null;
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++)
            max = Math.max(max, nums[i]);
        int mid = map.get(max);
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }
}