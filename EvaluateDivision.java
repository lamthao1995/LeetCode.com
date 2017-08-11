public class Solution {
    //undirected graph
    double[] rs;
    HashMap<String, Double> valueStock = new HashMap();
    HashMap<String, Set<String>> map = new HashMap();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        rs = new double[queries.length];
        for(int i = 0; i < equations.length; i++){
            if(!map.containsKey(equations[i][0])){
                map.put(equations[i][0], new HashSet<String>());
            }
            if(!map.containsKey(equations[i][1])){
                map.put(equations[i][1], new HashSet<String>());
            }
            map.get(equations[i][0]).add(equations[i][1]);
            map.get(equations[i][1]).add(equations[i][0]);
            String r1 = equations[i][0] + " " + equations[i][1];
            valueStock.put(r1, values[i]);
            String r2 = equations[i][1] + " " + equations[i][0];
            valueStock.put(r2, 1.0 / values[i]);
        }
        for(int i = 0; i < queries.length; i++){
            if(!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1]))
                rs[i] = -1.0;
            else if(queries[i][0].equals(queries[i][1])){
                rs[i] = 1.0;
            }else{
                dfs(new HashSet<String>(), queries[i][0], 1.0, queries[i][1], i);
                if(rs[i] == 0.0)
                    rs[i] = -1.0;
            }
        }
        return rs;
    }
    public void dfs(Set<String> visited, String vertex, double value, String target, int index){
        if(visited.contains(vertex) || map.containsKey(vertex) == false)
            return;
        visited.add(vertex);
        if(vertex.equals(target)){
            rs[index] = value;
            return;
        }
        boolean check  = false;
        for(String child : map.get(vertex)){
            String keyValue = vertex + " " + child;
            if(!valueStock.containsKey(keyValue)){
                continue;
            }
            check = true;
            double newVal = value * valueStock.get(vertex + " " + child);
            dfs(visited, child, newVal, target, index);
        }
    }
    
}