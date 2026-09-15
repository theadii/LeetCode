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


// can be done greddy also just pick  palindrome of size k or k+1 earliest as possible 
class Solution {

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0,
            start = 0;

        for (int r = k - 1; r < n; ++r) {
            // checck for len of k
            int l = r - k + 1;

            if (l >= start && check(s, l, r)) {
                ++ans;
                start = r + 1;
                continue;
            }
            // check for len of k+1
            l = r - k;
            if (l >= start && check(s, l, r)) {
                ++ans;
                start = r + 1;
            }
        }

        return ans;
    }

    private boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}