class Solution {
    public double myPow(double x, int n) {
       double pow = 1.0;
       long t = n;
       if(t<0)
           t = -t;
        //long t = Math.abs(n);
        while(t>0){
            if(t%2==1){
               pow =pow*x;
                t--;
            }
            else{
                x = x*x;
                t = t/2;            
            }
        }
        if(n<0)
            return 1.0/pow;
        return pow;
    }
}