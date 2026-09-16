class Solution {
    int dp[][];

    int MOD = 1000000007;
    int solve(int n,int i,int k){
        if(k==0)return 1;
        if(i>=n)return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int skip = solve(n,i+1,k) % MOD;
        int take = 0;

        for(int j=i+1;j<n;j++){
            take= (take % MOD) + (solve(n,j,k-1) % MOD);
        }

        return dp[i][k] =  (take + skip) % MOD;
    }
    public int numberOfSets(int n, int k) {
        // if(k == n-1){
        //     return 1;
        // }

        // dp = new int[n+1][n+1];
        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(n,0,k);

        dp = new int[1001][1001];

        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }

        for(int i=1;i<=k;i++){

            int prefix[] = new int[n+1];
            for(int x=n-1;x>=0;x--){
                prefix[x] = (prefix[x+1] + dp[i-1][x]) % MOD;
            }


            for(int j=n-1;j>=0;j--){

                int skip = dp[i][j+1];

                int take = prefix[j+1];

                dp[i][j] = (take + skip) % MOD;

            }
        }
        return dp[k][0];
    }
}