public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int curW = 0;
        int curA = 0;
        while(curW < word.length() && curA < abbr.length()){
            String num = "";
            if(abbr.charAt(curA) == '0')
                return false;
            while(curA < abbr.length() && Character.isDigit(abbr.charAt(curA))){
                num = num + abbr.charAt(curA);
                curA++;
            }
            if(num.equals("") == false){
                int n = Integer.parseInt(num);
                curW += n;
            }
            if(curW == word.length() && curA == abbr.length())
                return true;
            if(curW == word.length() || curA == abbr.length())
                return false;
            if(word.charAt(curW) != abbr.charAt(curA))
                return false;
            curW++;
            curA++;
        }
        return curW == word.length() && curA == abbr.length();
    }
}