class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(new String(i + ""));
        }
        while(list.size() != 1){
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < list.size() / 2; i++){
                String pair = "(" + list.get(i) + "," + list.get(list.size() - i - 1) + ")";
                tmp.add(pair);
            }
            list = tmp;
        }
        return list.get(0);
        
    }
}