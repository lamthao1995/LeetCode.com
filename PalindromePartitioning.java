public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rs = new ArrayList<>();
        if(s == null || s.length() == 0) return rs;
        add(s, 0, new ArrayList<String>(), rs);
        return rs;
    }
    public void add(String s, int index, List<String> partition, List<List<String>> rs){
        if(index == s.length()){
            List<String> arr = new ArrayList<>(partition);
            rs.add(arr);
            return;
        }
        String tmp = "";
        for(int i = index; i < s.length(); i++){
            tmp = tmp + s.charAt(i);
            if(isPalindrome(tmp)){
                partition.add(tmp);
                add(s, i + 1, partition, rs);
                partition.remove(partition.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}