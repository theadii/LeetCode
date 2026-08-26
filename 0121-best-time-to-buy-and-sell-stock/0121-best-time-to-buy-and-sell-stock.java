class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxi = 0;
        for(int i : prices){
            mini = Math.min(mini,i);
            maxi = Math.max(maxi,i - mini);
        }

        return maxi;
    }
}