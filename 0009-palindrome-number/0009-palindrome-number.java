class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int n = x;
        int k = 0;
        while(n!=0){
            int rem = n%10;
            k = k*10+rem;
            n = n/10;
        }
        if(k==x)
            return true;
        return false;
    }
}