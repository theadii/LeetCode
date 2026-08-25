class Solution {

    
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length;
        int maxi = 0;
        Arrays.sort(tiles,(a,b)->Integer.compare(a[0],b[0]));
        int arr[] = new int[n+1];
        int sum = 0;
        for(int i=0;i<n;i++){
            
            sum+=tiles[i][1] - tiles[i][0] + 1;
            arr[i+1] = sum;
            
        }

        for(int i=0;i<n;i++){

            int l = i;
            int r = n-1;

            int end = carpetLen + tiles[i][0] - 1;
            int p = i;
            while(l<=r){
                int mid = (l + r)/2;
                if(tiles[mid][0]<=end){
                    p = mid;
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }

            int curr = arr[p] - arr[i];
            curr+= Math.min(end,tiles[p][1]) - tiles[p][0] + 1;

           maxi =  Math.max(maxi,curr);
        }


        
        return maxi;

    }
}