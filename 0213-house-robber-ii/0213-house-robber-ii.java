class Solution {


    int solve(int[] nums,int i,int[] dp){
        if(i==0){
            return nums[0];
        }
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = nums[i] + solve(nums,i-2,dp);
        int npick = solve(nums,i-1,dp);
        return dp[i] = Math.max(pick,npick);

    }


    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n-1;i++){
            int pick = nums[i];
            if(i>1)pick+= dp[i-2];
            int npick = dp[i-1];
            
            dp[i] = Math.max(pick,npick);
        }

        int maxi1 = dp[n-2];
        int dp2[] = new int[n];
        
        dp2[1] = nums[1];
        for(int i=2;i<n;i++){
            int pick = nums[i];
            if(i>1) pick+=dp2[i-2];
            int npick = dp2[i-1];

            dp2[i] = Math.max(pick,npick);
        }
        
        int maxi2 = dp2[n-1];

        return Math.max(maxi1,maxi2);
    }
}