class Solution {

    Boolean solve(int i,int ttl,int[] arr,Boolean[][] dp){
        if(i>= arr.length || ttl <0) return false;

        if(dp[i][ttl]!= null) return dp[i][ttl];
        if(ttl == 0){
            return true;
        }
        
        Boolean p = solve(i+1,ttl - arr[i],arr,dp);
        Boolean np = solve(i+1,ttl,arr,dp);

        return dp[i][ttl] = (p || np);
    }


    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums) sum+=x;

        if(sum%2!=0) return false;
        Boolean dp[][] = new Boolean[n+1][(sum/2) + 1];

        return solve(0,sum/2,nums,dp);
    }
}