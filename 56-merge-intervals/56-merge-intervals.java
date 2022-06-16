class Solution {
     int compareInterval(int[] i1, int[] i2){
        return i1[0]-i2[0];
    }
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length ==1 || intervals.length ==0)
            return intervals;
        int n= intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res=0; 
        for(int i=1; i<n; i++){
            if(intervals[res][1] >= intervals[i][0]){
                //merge
                intervals[res][1] = Math.max(intervals[res][1], intervals[i][1]);
                intervals[res][0] = Math.min(intervals[res][0], intervals[i][0]);
            }
            else{
                res++;
                intervals[res] = intervals[i];
            }
        }
        int[][] ans = new int[res+1][];
        for(int i=0 ; i<=res ;i++){
             ans[i] = intervals[i];
        }        
        return ans;
    }
   
}