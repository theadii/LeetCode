class Solution {
    public boolean checkDivisibility(int n) {
        int p = 1;
        int s = 0;
        int t = n;
        while(t!=0){
            int d = t%10;
            s+=d;
            p*=d;
            t/=10;
            if(s+p > n) return false;
        }

        return n % (p + s)==0;
    }
}