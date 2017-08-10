/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
   HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone_(node);
    }
    public UndirectedGraphNode clone_(UndirectedGraphNode node){
        if(node == null) return node;
        
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for(UndirectedGraphNode neigh : node.neighbors){
            clone.neighbors.add(clone_(neigh));
        }
        return clone;
    }
   
}