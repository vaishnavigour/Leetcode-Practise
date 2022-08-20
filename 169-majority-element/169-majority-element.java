class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key : map.keySet()){
            int v = map.get(key);
            if(v > nums.length/2)
                return key;
        }
        return 0;
        
    }
}