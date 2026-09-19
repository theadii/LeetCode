class Solution {

    boolean check(int arr[],int i,int j){
        int diff = arr[i+1] - arr[i];

        for(int k=i+1;k<=j;k++){
            if(arr[k] - arr[k-1] != diff){
                return false;
            }
        }
        return true;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;

        int n = nums.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                if(j-i+1 >=3){
                    if(check(nums,i,j)){
                        ans++;
                    }
                }


            }
        }

        return ans;
    }
}