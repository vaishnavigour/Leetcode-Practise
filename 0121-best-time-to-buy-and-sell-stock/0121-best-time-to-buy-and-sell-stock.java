class Solution {
    public int maxProfit(int[] arr) {
        int profit=0, sellday=0;
        for(int i=0;i<arr.length;i++){
            if(arr[sellday]>arr[i]){
                sellday=i;
            }
            if(arr[i]-arr[sellday]>profit){
                profit = arr[i]-arr[sellday];
            }
                
        }
        if(profit<0)
            return 0;
        return profit;
    }
}