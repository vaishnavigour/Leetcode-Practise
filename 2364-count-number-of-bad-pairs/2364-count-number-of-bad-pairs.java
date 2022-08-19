class Solution {
    public long f(long n){
        return n*(n-1)/2;
    }
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        long total = f(n);
        for(int i=0;i<n;i++){
            mp.put(i-nums[i] , mp.getOrDefault(i-nums[i],0)+1);
        }
        long goodpairs =0;
        for(int key:mp.keySet()){
            int v = mp.get(key);
            if(v>1){
                goodpairs += f(v);
            }
        }
      
        return total-goodpairs;
    }
}
