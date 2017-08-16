public class Solution {
    List<Integer> debt = new ArrayList<>();
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int[] t : transactions){
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        for(int key : map.keySet()){
            if(map.get(key) == 0) continue;
            debt.add(map.get(key));
        }
        return dfs(0, 0);
    }
    public int dfs(int s, int cnt){
        while(s < debt.size() && debt.get(s) == 0) s++;
        int res = Integer.MAX_VALUE;
        for(int i = s + 1, prev = -1; i < debt.size(); ++i){
            if(i != prev && debt.get(i) * debt.get(s) < 0L){// skip 2 element with the same sign 
                debt.set(i, debt.get(i) + debt.get(s));
                res = Math.min(res, dfs(s + 1, cnt + 1));
                debt.set(i, debt.get(i) - debt.get(s));
                prev = i;
            }
        }
        return res < Integer.MAX_VALUE ? res : cnt;
    }
}
// public:
//     int minTransfers(vector<vector<int>>& trans) {
//         unordered_map<int, long> bal; // each person's overall balance
//         for(auto& t: trans) bal[t[0]] -= t[2], bal[t[1]] += t[2];
//         for(auto& p: bal) if(p.second) debt.push_back(p.second);
//         return dfs(0, 0);
//     }
    
// private:
//     int dfs(int s, int cnt) { // min number of transactions to settle starting from debt[s]
//     	while (s < debt.size() && !debt[s]) ++s; // get next non-zero debt
//     	int res = INT_MAX;
//     	for (long i = s+1, prev = 0; i < debt.size(); ++i)
//     	  if (debt[i] != prev && debt[i]*debt[s] < 0) // skip already tested or same sign debt
//     	    debt[i] += debt[s], res = min(res, dfs(s+1,cnt+1)), prev = debt[i]-=debt[s];
//     	return res < INT_MAX? res : cnt;
//     }
    
//     vector<long> debt; // all non-zero balances