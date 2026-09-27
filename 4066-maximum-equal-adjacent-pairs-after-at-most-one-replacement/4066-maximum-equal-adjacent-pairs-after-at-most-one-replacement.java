class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int maxi = 0;
        HashMap<String, Integer> cnts = new HashMap<>();
        
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] == nums[i]) {
                ans++;
            } else {
                int minVal = Math.min(nums[i - 1], nums[i]);
                int maxVal = Math.max(nums[i - 1], nums[i]);
                StringBuilder key = new StringBuilder();
                key.append(minVal);
                key.append('|');
                key.append(maxVal);
                
                int count = cnts.getOrDefault(key.toString(), 0) + 1;
                cnts.put(key.toString(), count);
                maxi = Math.max(maxi, count);
            }
        }
        
        return ans + maxi;
    }
}