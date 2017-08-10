public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet();
        set.add('a'); set.add('o'); set.add('i'); set.add('u'); set.add('e');
        set.add('A'); set.add('O'); set.add('I'); set.add('U'); set.add('E');
        
        char arr[] = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(!set.contains(arr[start])){
                start++;
                continue;
            }
            if(!set.contains(arr[end])){
                end--;
                continue;
            }
            
            char tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            end--;
            start++;
        }
        return new String(arr);
    } 
}