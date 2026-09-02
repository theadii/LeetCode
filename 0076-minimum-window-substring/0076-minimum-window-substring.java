class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        Map<Character,Integer> mp = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        int minlen = Integer.MAX_VALUE;
        int idx = -1;
        int cnt = 0;
        while(r<s.length()){
            char x = s.charAt(r);
            if(mp.containsKey(x) && mp.get(x)>0){
                cnt++;
            }
            mp.put(x,mp.getOrDefault(x,0)-1);

            while(cnt == t.length()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    idx=l;
                }
                char z = s.charAt(l);
                mp.put(z,mp.get(z)+1);
                if(mp.get(z)>0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return idx == -1 ? "" : s.substring(idx, idx + minlen);

    }
}