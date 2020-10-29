//380 hashmap and arraylist remove inorder to make it o(1) need to swap the balue between randomindex lastindex remove //from the last of the list
//the map contains<Integer, the index of the list>
class RandomizedSet {
    
    HashMap<Integer, Integer> map;
    List<Integer> list; //store number and getRandom() method
    int ind = 0;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind = map.getOrDefault(val, -1);
        if(ind == -1) return false;
        Collections.swap(list, ind, list.size() - 1);
        int swap = list.get(ind);
        //need to update the index that swapped with
        map.put(swap, ind);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int ind = (int)(Math.random()) * (list.size());
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */