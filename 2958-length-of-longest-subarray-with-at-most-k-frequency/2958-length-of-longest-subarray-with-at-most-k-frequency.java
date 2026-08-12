class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n  = nums.length;

        int maxi = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        int l = 0;
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            while( mp.get(nums[i])>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                l++;
            }

            maxi = Math.max(maxi,i-l+1);
        }

        return maxi;
    }
}