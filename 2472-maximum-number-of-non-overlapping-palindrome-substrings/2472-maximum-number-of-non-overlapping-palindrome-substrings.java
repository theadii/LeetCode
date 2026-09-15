// class Solution {

//     int dp[][];
    
//     int[][] pal;

//     boolean isP(int i, int j, String s) {
//         if (i >= j) return true;

//         if (pal[i][j] != -1)
//             return pal[i][j] == 1;

//         if (s.charAt(i) != s.charAt(j))
//             return false;

//         pal[i][j] = isP(i + 1, j - 1, s) ? 1 : 0;
//         return pal[i][j] == 1;
//     }

//     int helper(int i,int j,int k,String s){
//         if(j>=s.length() || i>=s.length()) return 0;

//         if(dp[i][j]!=-1) return dp[i][j];

//         if(isP(i,j,s)){
            
//             int take = 1 + helper(j+1,j+k,k,s);
//             int grow = helper(i,j+1,k,s);
//             int slide = helper(i+1,j+1,k,s);
//             return dp[i][j] = Math.max(grow,Math.max(slide,take));
//         }
//         else{
            
//             int grow = helper(i,j+1,k,s);
//             int slide = helper(i+1,j+1,k,s);

//             return dp[i][j]= Math.max(grow,slide);
//         }

//     }
//     public int maxPalindromes(String s, int k) {
//         int n = s.length();
//         dp = new int[n+1][n+1];
//         pal = new int[n+1][n+1];
//         if(k==1) return n;
//         for(int i=0;i<=n;i++){
//             Arrays.fill(dp[i],-1);
//             Arrays.fill(pal[i],-1);
//         }
//         return helper(0,k-1,k,s);
//     }
// }

class Solution {

    int[][] pal;

    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // -1 = not checked
        //  0 = not palindrome
        //  1 = palindrome
        pal = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(pal[i], -1);
        }

        int ans = 0;
        int start = 0;

        for (int r = k - 1; r < n; r++) {

            // Check palindrome of length k
            int l = r - k + 1;

            if (l >= start && isP(l, r, s)) {
                ans++;
                start = r + 1;
                continue;
            }

            // Check palindrome of length k + 1
            l = r - k;

            if (l >= start && isP(l, r, s)) {
                ans++;
                start = r + 1;
            }
        }

        return ans;
    }

    boolean isP(int l, int r, String s) {

        if (l >= r)
            return true;

        if (pal[l][r] != -1)
            return pal[l][r] == 1;

        if (s.charAt(l) != s.charAt(r)) {
            pal[l][r] = 0;
            return false;
        }

        boolean ans = isP(l + 1, r - 1, s);

        pal[l][r] = ans ? 1 : 0;

        return ans;
    }
}