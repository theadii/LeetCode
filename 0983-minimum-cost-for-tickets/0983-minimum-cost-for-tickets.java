class Solution {
    int dp[][] = new int[367][400];
   int helper(int i, int[] days, int[] costs, int expiry) {
    
    if (i == days.length)
        return 0;
    
    if(dp[i][expiry]!=-1) return dp[i][expiry];
    
    if (days[i] <= expiry) {
        return helper(i + 1, days, costs, expiry);
    }

    int one = costs[0] + helper(i + 1, days, costs,days[i]);
    int week = costs[1] + helper(i + 1, days, costs,days[i] + 6);
    int month = costs[2] + helper(i + 1, days, costs,days[i] + 29);

    return dp[i][expiry] = Math.min(one, Math.min(week, month));
}


    public int mincostTickets(int[] days, int[] costs) {
        int n  = days.length;
        for(int i=0;i<367;i++){
            Arrays.fill(dp[i],-1);
        }
        

        return helper(0,days,costs,0);
    }
}