class Solution {
    int dp[][] = new int[501][501];
    
    int solve(int l,int r,int pre[]){
        if(l>=r){
            return 0;
        }
        if(dp[l][r]!=-1) return dp[l][r];
        int score = 0;

        for(int mid = l;mid<r;mid++){
            int lSum = pre[mid] - (l>0 ? pre[l-1] : 0);
            int rSum = pre[r] - pre[mid];

            if(lSum<rSum){
                score = Math.max(score,lSum + solve(l,mid,pre));
            }  
            else if(rSum<lSum){
                score = Math.max(score,rSum + solve(mid + 1,r,pre));
            }
            else{
                score = Math.max(lSum + solve(l,mid,pre),rSum + solve(mid+1,r,pre));
            }
        }
        return dp[l][r] = score;
    }


    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int prefix[] = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=stoneValue[i];
            prefix[i] = sum;
        }
        for(int i=0;i<501;i++){
        Arrays.fill(dp[i],-1);
         }

        return solve(0,n-1,prefix);
    }
}