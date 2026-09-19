class Solution {
    public int minimumLength(String s) {
        int i= 0 ;
        int j = s.length() - 1;
        int n = s.length();
        while(i<j){
            char c = s.charAt(i);
            char c2 = s.charAt(j);

            if(c == c2){
                while(i< n && s.charAt(i) == c) i++;
                while(j >=0 && s.charAt(j) == c) j--;
            }
            else{
                break;
            }

        }
        return Math.max(0,j-i +1);
    }
}