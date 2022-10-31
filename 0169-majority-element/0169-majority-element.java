class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int k =nums.length/2;
        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            if(e.getValue()>k)
                return e.getKey();
        }
        return 0;
    }
}