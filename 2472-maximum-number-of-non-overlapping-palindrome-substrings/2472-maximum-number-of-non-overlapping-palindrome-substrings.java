class Solution {

    int dp[][];
    
    int[][] pal;

    boolean isP(int i, int j, String s) {
        if (i >= j) return true;

        if (pal[i][j] != -1)
            return pal[i][j] == 1;

        if (s.charAt(i) != s.charAt(j))
            return false;

        pal[i][j] = isP(i + 1, j - 1, s) ? 1 : 0;
        return pal[i][j] == 1;
    }

    int helper(int i,int j,int k,String s){
        if(j>=s.length() || i>=s.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(isP(i,j,s)){
            
            int take = 1 + helper(j+1,j+k,k,s);
            int grow = helper(i,j+1,k,s);
            int slide = helper(i+1,j+1,k,s);
            return dp[i][j] = Math.max(grow,Math.max(slide,take));
        }
        else{
            
            int grow = helper(i,j+1,k,s);
            int slide = helper(i+1,j+1,k,s);

            return dp[i][j]= Math.max(grow,slide);
        }

    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        dp = new int[n+1][n+1];
        pal = new int[n+1][n+1];
        if(k==1) return n;
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
            Arrays.fill(pal[i],-1);
        }
        return helper(0,k-1,k,s);
    }
}