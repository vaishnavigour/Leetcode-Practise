class Solution {
    public List<List<Integer>> generate(int k) {
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        int i=2;
        List<Integer> d = new ArrayList<Integer>();
        d.add(1);
        ans.add(d);
        while(i<=k){
            List<Integer> ds = new ArrayList<Integer>(i);
            ds.add(1);
            ds.add(ds.size()-1,1);
            for(int j=1;j<i-1;j++){
               ds.add(j,ans.get(ans.size()-1).get(j-1)+ans.get(ans.size()-1).get(j)); 
               
            }
            ans.add(ds);
            i++;
        }
        return ans;
    }
}