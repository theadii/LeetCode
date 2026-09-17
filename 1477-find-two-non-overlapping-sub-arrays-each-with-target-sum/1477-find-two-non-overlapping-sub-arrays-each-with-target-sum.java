class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int l=0;
        
        int n = arr.length;
        int best = Integer.MAX_VALUE;
        int mini[] = new int[n];
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            sum+= arr[r];

            while(sum > target){
                sum-= arr[l];
                l++;
            }

            if(sum == target){
                int len = r - l + 1;
                if(l > 0 && mini[l-1]!=0 && mini[l-1]!=Integer.MAX_VALUE){
                    ans = Math.min(ans,len + mini[l-1]);
                }
                best = Math.min(best,len);
            }

            mini[r] = best;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}