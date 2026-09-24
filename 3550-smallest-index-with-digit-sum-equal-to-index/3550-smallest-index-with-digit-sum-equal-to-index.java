class Solution {

    int DigitSum(int n){
        int sum = 0;

        while(n!=0){
            int d = n%10;
            n/=10;
            sum+=d;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i == DigitSum(nums[i])){
                return i;
            }
        }

        return -1;

    }
}