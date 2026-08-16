class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        int arr[] = new int[3];

        for(int i=0;i<n;i++){
            arr[stones[i]%3]++;
        }

        if(arr[0]%2==0){
            return (arr[1]>0 && arr[2]>0);
        }
        else{
            return (Math.abs(arr[1]-arr[2]) > 2);
        }
    }
}