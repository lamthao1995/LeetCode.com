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
    List<List<Integer>> rs = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        traversing(root, 0, sum);
       return rs;
    }
    public void traversing(TreeNode root, int tempSum,int sum){
        if(root == null) return;
        this.arr.add(root.val);
        tempSum += root.val;
        if(tempSum == sum && root.left == null && root.right == null){
            ArrayList<Integer> t = new ArrayList<>(this.arr);
            rs.add(t);
        }
        traversing(root.left, tempSum, sum);
        traversing(root.right, tempSum, sum);
        this.arr.remove(arr.size() - 1);
    }
}
}