public class Solution {
    int height = 0, width;
    List<List<String>> rs = new ArrayList<>();
    public List<List<String>> printTree(TreeNode root){
        if(root == null)
            return rs;
        traverse(root, 0);
        width = (int)Math.pow(2, height) - 1;
        for(int i = 0; i < height; i++){
            List<String> tmp = new ArrayList<>();
            for(int j = 0; j < width; j++){
                tmp.add("");
            }
            rs.add(tmp);
        }
        int index = (width / 2);
        rs.get(0).set(index, root.val + "");
        addNodeString(root.left, true, index, 1);
        addNodeString(root.right, false, index, 1);
        return rs;
        
       
    }
    public void addNodeString(TreeNode root, boolean isLeft, int index, int depth){
        if(root == null)
            return;
        List<String> tmp = rs.get(depth);
        int indexInsert = 0;
        int dis =(int)Math.pow(2, height - depth - 1);
       // System.out.println(dis);
        if(isLeft){
           indexInsert = index - dis; 
        }else{
           indexInsert = index + dis; 
        }
        tmp.set(indexInsert, root.val + "");
        addNodeString(root.left, true, indexInsert, depth + 1);
        addNodeString(root.right, false, indexInsert, depth + 1);
    }
    
    public void traverse(TreeNode root, int depth){
        if(root == null){
            height = Math.max(height, depth);
        }else{
            traverse(root.left, depth + 1);
            traverse(root.right, depth + 1);
        }
        
        //[1,2,5,3,null,null,null,4]
    }
}