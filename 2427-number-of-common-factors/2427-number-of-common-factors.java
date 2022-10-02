class Solution {
    public int commonFactors(int a, int b) {
        int c = Math.max(a,b);
        int d = Math.min(a,b);
        int cnt=0;
        for(int i=1; i<=d;i++){
            if(c%i==0 && d%i==0)
                cnt++;
        }
        return cnt;
    }
}