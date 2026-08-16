class Solution {

    Boolean solve(int nums[],int i,int ttl,Boolean dp[][]){
        if(ttl == 0){
            return true;
        }
        if(i>=nums.length || ttl < 0) return false;

        if(dp[i][ttl]!=null) return dp[i][ttl];

        Boolean pick = solve(nums,i+1,ttl - nums[i],dp);
        Boolean NotPick = solve(nums,i+1,ttl,dp);

        return dp[i][ttl] = (pick || NotPick);
        


    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int ttl = 0;
        for(int i=0;i<n;i++){
            ttl+=nums[i];
        }

        if(ttl%2!=0) return false;
        ttl/=2;
        Boolean dp[][] = new Boolean[n][ttl+1];
        return solve(nums,0,ttl,dp);
    }
}