class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]= new int[nums.length];
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]<pivot){
                ans[i]=nums[j];
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]==pivot){
                ans[i]=nums[j];
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]>pivot){
                ans[i]=nums[j];
                i++;
            }
        }
        return ans;
    }
}