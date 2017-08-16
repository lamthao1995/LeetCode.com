public class Solution {
    Set<String> rs = new HashSet();
    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        for(char c : s.toCharArray()){
            map[c]++;
        }
        if(!canGenerate(map))
            return new ArrayList<String>();
        char specialC = 0;
        char[] arr = new char[s.length() / 2];
        int k = 0;
        for(int i = 0; i < map.length; i++){
            if(map[i] == 0) continue;
            if(map[i] % 2 == 1){
                specialC = (char) i;    
            }
            for (int j = 0; j < map[i] / 2; j++) {
                arr[k++] = (char) i;
            }
        }
        permute(arr, specialC, 0, arr.length);
        return new ArrayList<String>(rs);
        
    }
    public void permute(char[] arr, char specialC, int l, int r){
        if(l == r){
            StringBuilder sb = new StringBuilder(String.valueOf(arr));
            String res = sb.toString() + (specialC == 0 ? "" : specialC) + sb.reverse().toString();
            rs.add(res);
        }else{
            for(int i = l; i < r; i++){
                if(l == i || arr[l] != arr[i]){
                    swap(i, l, arr);
                    permute(arr, specialC, l + 1, r);
                    swap(i, l, arr);    
                }
            }
        }
    }
    public boolean canGenerate(int[] map){
        int count = 1;
        for(int i = 0 ; i < map.length; i++){
            count -= (map[i] % 2);
        }
        if(count < 0) 
            return false;
        //System.out.print("True");
        return true;
    }
    public void swap(int x, int y, char[] arr){
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}