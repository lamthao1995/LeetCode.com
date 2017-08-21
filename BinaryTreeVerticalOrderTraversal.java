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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null)
            return rs;
        HashMap<Integer, List<Integer>> map = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> level = new LinkedList();
        queue.offer(root);
        level.offer(0);
        int minLevel = 0;
        int maxLevel = 0;
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            int l = level.poll();
            //track min and max 
            minLevel = Math.min(minLevel, l);
            maxLevel = Math.max(maxLevel, l);
            
            if(map.containsKey(l)){
                map.get(l).add(p.val);
                
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(p.val);
                map.put(l, list);
            }
            if(p.left != null){
                queue.add(p.left);
                level.add(l - 1);
            }
            if(p.right != null){
                queue.add(p.right);
                level.add(l + 1);
            }
        }
        for(int i = minLevel; i <= maxLevel; i++){
            if(map.containsKey(i)){
                rs.add(map.get(i));
            }
        }
        return rs;
    }
}