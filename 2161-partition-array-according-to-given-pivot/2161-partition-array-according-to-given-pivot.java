class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
       
        int n = nums.length;


        for(int i=0;i<n;i++){
            if(nums[i]< pivot){
                arr.add(nums[i]);
                
            }
            else if(nums[i]==pivot){
                arr2.add(0,nums[i]);
                
            }
            else{
               arr2.add(nums[i]);
               
            }
        }

        

        int ans[] = new int[n];
        int idx=0;

        for(int x: arr){
            ans[idx] = x;
            idx++;
        }

        for(int x: arr2){
            ans[idx] = x;
            idx++;
        }

        return ans;
    }
}