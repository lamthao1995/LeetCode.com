public class Solution {
    int[] trace;
    public String addBoldTag(String s, String[] dict) {
        int len = s.length();
        trace = new int[len];
        for(String p : dict){
            kmpSearch(s, p);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(trace[i] == 1){
                if(i == 0 || trace[i - 1] == 0){
                    sb.append("<b>").append(s.charAt(i));
                }else{
                    sb.append(s.charAt(i));
                }
            }else{
                if(i > 0 && trace[i - 1] == 1){
                    sb.append("</b>").append(s.charAt(i));
                }else{
                    sb.append(s.charAt(i));
                }
                
            }
        }
        if(trace[len - 1] == 1){
            sb.append("</b>");
        }
        return sb.toString();
    }
    private void kmpSearch(String s, String p){
        int hashP = p.hashCode();
        int lenP = p.length();
        for(int i = 0; i <= s.length() - lenP; i++){
            String tmp = s.substring(i, i + lenP);
            if(tmp.hashCode() == hashP){
                if(tmp.equals(p)){
                    for(int j = i; j < i + lenP; j++){
                        trace[j] = 1;
                    }
                }
            }
        }
    }
}