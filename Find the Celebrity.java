/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cele = 0;
        for(int i = 1; i < n; i++)
            if(knows(cele, i))
                cele = i;
        for(int i = 0; i < n; i++){
            if(i == cele) continue;
            if(knows(cele, i) || !knows(i, cele))
                return -1;
        }
        return cele;
    }
}