class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int n = s.length();
        
        for(int i=0;i<n;i++){
            Character c = s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }


        for(int i=0;i<n;i++){
            Character c = s.charAt(i);
            if(mp.get(c)==1) return i;
        }

        return -1;
    }
}