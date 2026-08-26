class Solution {

    int solve(int i,int j,int[] arr,int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==j){
            return arr[i];
        }

        return dp[i][j] = Math.max(arr[i] - solve(i+1,j,arr,dp), arr[j] - solve(i,j-1,arr,dp));
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,nums.length - 1,nums,dp) >=0;
    }
}