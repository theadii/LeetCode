class Solution {
    int ans = 0;
    int dp[][];
    int solve(int i,int ttl,int[] arr){
        if(i== arr.length || ttl < 0){
            return 0;
        }
        if(dp[i][ttl]!= -1) return dp[i][ttl];
        if(ttl == 0){
            return 1;
        }
        

        int take = solve(i,ttl - arr[i],arr);
        int nTake = solve(i+1,ttl,arr);


        return dp[i][ttl] = take + nTake;
    }

    public int change(int amount, int[] coins) {
        int n  = coins.length;
        dp = new int[n+1][amount + 1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,amount,coins);
    }
}