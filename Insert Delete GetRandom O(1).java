public class RandomizedSet {
    private int size;
    private Set<Integer> set;
    private Random rd = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet();
        this.size = 0;
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        set.add(val);
        this.size++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val))
            return false;
        set.remove(val);
        this.size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int counter = 0;
        int rdIndex = rd.nextInt(size);
        for(int i : set)
        {
            if(counter == rdIndex)
                return i;
            counter++;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */