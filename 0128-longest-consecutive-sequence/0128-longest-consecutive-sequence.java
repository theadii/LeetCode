class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        int maxi = 0;
        for(int x : set){
            int srt = x - 1;
            if(!set.contains(srt)){
                int cnt = 0;
                while(set.contains(++srt)){
                    cnt++;
                }
                maxi = Math.max(cnt,maxi);
            }
        }

        return maxi;
    }
}