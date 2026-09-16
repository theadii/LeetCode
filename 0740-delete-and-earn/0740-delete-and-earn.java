class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxi = -1;

        for(int x : nums){
            maxi = Math.max(x,maxi);
        }

        int freq[] = new int[maxi+1];
        for(int x : nums){
            freq[x] += x;
        }
        int prev1 = 0;
        int prev2 = 0;

        for(int i=1;i<=maxi;i++){
            int take = freq[i] + prev2;
            int ntake = prev1;

            int curr = Math.max(take,ntake);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}