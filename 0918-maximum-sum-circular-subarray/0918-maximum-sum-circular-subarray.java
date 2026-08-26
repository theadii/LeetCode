class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int nonCircular = nums[0];

        int circular = -nums[0];

        int sum1 = 0;
        int sum2 = 0;
        int ttl = 0;


        for(int x : nums){
            sum1+=x;
            sum2+=-x;
            ttl+=x;

            nonCircular = Math.max(nonCircular,sum1);
            circular = Math.max(circular,sum2);

            if(sum1<0){
                sum1 = 0;
            }

            if(sum2 < 0){
                sum2 = 0;
            }
        }
        if (nonCircular < 0) {
            return nonCircular;
        }

        return Math.max(nonCircular,ttl + circular);
    }

    
}