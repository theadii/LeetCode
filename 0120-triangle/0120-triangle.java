class Solution {

    int solve(List<List<Integer>> t,int i,int j,List<int[]>dp){
      
        if(i==t.size()-1){
            return t.get(i).get(j);
        }

        if(dp.get(i)[j]!=Integer.MAX_VALUE) return dp.get(i)[j];

        int d = t.get(i).get(j)+ solve(t,i+1,j,dp);
        int dr = t.get(i).get(j) + solve(t,i+1,j+1,dp);

        return dp.get(i)[j] = Math.min(d,dr);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
       
        // int n = triangle.size();
        // int m = triangle.get(n-1).size();

        // List<int[]> dp = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     int arr[] = new int[i+1];
        //     Arrays.fill(arr,Integer.MAX_VALUE);
        //     dp.add(arr);
        // }

        // return solve(triangle,0,0,dp);
        int n = triangle.size();
        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if (j == 0) {
                    // Left edge: only came from top-left element
                    dp[i][j] = dp[i - 1][0] + triangle.get(i).get(0);
                } else if (j == i) {
                    // Right edge: only came from top-right element
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    // Middle elements: take min of both parent paths
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }


        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[n-1][i]);
        }

        return ans;
       
    }
}