/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Queue<TreeNode> s = new LinkedList();
    public BSTIterator(TreeNode root) {
        inOrder(root);
    }
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        s.add(root);
        inOrder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return s.isEmpty() == false;
    }

    /** @return the next smallest number */
    public int next() {
        return s.poll().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */