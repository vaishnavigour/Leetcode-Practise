class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        long t=n;
        if(t<0)
            t = -t;
        while(t>0){
            if(t%2==1){
                ans = ans*x;
                t--;
            }
            else{
                x = x*x;
                t=t/2;
            }
        }
        if(n<0)
            return 1/ans;
        return ans;
    }
}