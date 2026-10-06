class Solution {
    public int minAddToMakeValid(String s) {
        int o = 0;
        
        int c = 0;
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                o++;
            }
            else{
                c++;
            }

            if(c>o){
                ans+= c - o;
                c = 0;
                o = 0;
            }
        }

       if(c!=o){
        ans+= Math.abs(o-c);
       }
        return ans;
    }
}