public class Solution {
    public String[] findWords(String[] words) {
        String line2 = "asdfghjklASDFGHJKL";
        String line1 = "qwertyuiopQWERTYUIOP";
        String line3 = "zxcvbnmZXCVBNM";
        List<String> container = new ArrayList<>();
        for(String s : words){
            boolean isLine1 = false, isLine2 = false, isLine3 = false;
            for(int i = 0; i < s.length(); i++){
                String c = s.charAt(i) + "";
                if(line1.contains(c)){
                    isLine1 = true;
                }else if(line2.contains(c)){
                    isLine2 = true;
                }else if(line3.contains(c)){
                    isLine3 = true;
                }
                
            }
            if((isLine1 & isLine2) || (isLine2 & isLine3) || (isLine3 & isLine1))
                continue;
            container.add(s);
        }
        return container.toArray(new String[container.size()]);
    }
}