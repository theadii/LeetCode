class Solution {
    public int longestValidParentheses(String s) {
        int l = 0;
        int r = 0;

        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            char c  = s.charAt(i);
            if(c == '('){
                l++;
            }
            else{
                r++;
            }

            if(l<r){
                r = 0;
                l=0;
            }
            if(l==r){
                int curr = Math.min(l,r);
                ans = Math.max(curr,ans);
            }
            
           
        }


        l = 0;
        r = 0;
        for(int i=n-1;i>=1;i--){
            char c  = s.charAt(i);
            if(c == ')'){
                r++;
            }
            else l++;

            if(l>r){
                l = 0;
                r = 0;
            }
            
            if(l==r){
                int curr = Math.min(l,r);
                ans = Math.max(curr,ans);
            }
        }

        return ans*2;
    }
}