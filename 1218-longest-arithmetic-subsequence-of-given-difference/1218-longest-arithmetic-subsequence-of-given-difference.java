class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> mp = new HashMap<>();

        int ans = 0;

        int n = arr.length;

        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i] - difference)){
                mp.put(arr[i],mp.get(arr[i] - difference) + 1);
            }
            else{
                mp.put(arr[i],1);
            }
            ans = Math.max(ans,mp.get(arr[i]));
        }

        return ans;
    }
}