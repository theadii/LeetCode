class Solution {
    public int minimumDeletions(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        int mxi = 0;
        int mni = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]>maxi){
                maxi = nums[i];
                mxi = i;
            }
            if(nums[i]<mini){
                mini = nums[i];
                mni = i;
            }
        }


        int first = Math.min(mxi,mni);
        int sec = Math.max(mxi,mni);

        
        return Math.min(sec+1,Math.min(n-first,(first+1)+(n-sec)));
    }
}