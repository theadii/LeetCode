class Solution {

    int solve(int i,int j,int[] arr){
        if(i==j){
            return arr[i];
        }

        return Math.max(arr[i] - solve(i+1,j,arr), arr[j] - solve(i,j-1,arr));
    }
    public boolean predictTheWinner(int[] nums) {
        return solve(0,nums.length - 1,nums) >=0;
    }
}