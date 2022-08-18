class Solution {
    public int maxProfit(int[] arr) {
        int p=0;
        int sellday = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[sellday]>arr[i])
                sellday = i;
            p = Math.max(p, arr[i]-arr[sellday]);
        }
        return p;
    }
}