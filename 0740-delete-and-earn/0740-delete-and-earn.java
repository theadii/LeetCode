class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> freq = new LinkedHashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        int dp[] = new int[freq.size()];
        int arr[] = new int[freq.size()];
        int idx=0;
        for(int x : freq.keySet()){
            arr[idx] = x;
            idx++;
        }

        dp[0] = arr[0] * freq.get(arr[0]);

        for(int i=1;i<freq.size();i++){

            int take = arr[i] * freq.get(arr[i]);
            if(arr[i] != arr[i-1] +1){
                take += dp[i-1];
            }
            else{
                if(i>1) take += dp[i-2];
            }

            int ntake = dp[i-1];
            dp[i] = Math.max(take,ntake);
        }

        return dp[dp.length-1];

        
    }
}