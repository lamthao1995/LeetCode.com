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
    public TreeNode str2tree(String s) {
        if(s.length() == 0)
            return null;
        int i = 0, j = 0;
        while(j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-'))
            j++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(i, j)));
        //left child
        if(j < s.length()){
            i = j;
            int count = 1;
            while(j < s.length() - 1 && count != 0){
                j++;
                if(s.charAt(j) == ')') count--;
                if(s.charAt(j) == '(') count++;
            }
            root.left = str2tree(s.substring(i + 1, j));
        }
        j++;
        if(j < s.length()){
            root.right = str2tree(s.substring(j + 1, s.length() - 1));
        }
        return root;
    }
}