public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index){
        if(index == special.size())
            return finalStep(price, needs);
        List<Integer> needClone = new ArrayList<>(needs);
        int i = 0;
        for(; i < special.get(index).size() - 1; i++){
            int diff = needClone.get(i) - special.get(index).get(i);
            if(diff < 0)
                break;
            needClone.set(i, diff);
        }
        if(i == special.get(index).size() - 1)
            return Math.min(special.get(index).get(i) + shopping(price, special, needClone, index),
                           shopping(price, special, needs, index + 1));
        else
            return shopping(price, special, needs, index + 1);
    }
    public int finalStep(List<Integer> price, List<Integer> needs){
        int sum = 0;
        for(int i = 0; i < price.size(); i++){
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
   
}