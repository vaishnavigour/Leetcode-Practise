class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key : map.keySet()){
            int v = map.get(key);
            if(v > nums.length/3)
                l.add(key);
        }
        return l;
    }
}