class Solution {
    int solve(int turn,int i,int m,int[] arr,int dp[][][]){
        if(dp[turn][i][m]!= - 1) return dp[turn][i][m];
        if(i>=arr.length) return 0;

        int stone = 0;
        int result = (turn == 0) ? -1 : Integer.MAX_VALUE;

        for(int x=1;x<=Math.min(arr.length-i,m*2);x++){
            stone+= arr[i+x-1];

            if(turn == 0){
                result = Math.max(result,stone + solve(1,i+x,Math.max(x,m),arr,dp));
            }
            else{
                result = Math.min(result,solve(0,i+x,Math.max(x,m),arr,dp));
            }
        }

        return dp[turn][i][m] = result;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int dp[][][] = new int[2][n+1][n+1];

        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,1,piles,dp);
    }
}