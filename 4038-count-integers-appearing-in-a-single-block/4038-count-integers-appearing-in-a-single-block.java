class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Integer> first = new HashMap<>();
        Map<Integer,Integer> last = new HashMap<>();
        Map<Integer,Integer> freq = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(!first.containsKey(nums[i])){
                first.put(nums[i],i);
            }
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            last.put(nums[i],i);
        }

        int ans = 0;
        
        for(Map.Entry<Integer,Integer> x : freq.entrySet()){
            int key = x.getKey();
            int val = x.getValue();

            if( last.get(key) - first.get(key) + 1 == val) ans++;
        }

        return ans;
    }
}