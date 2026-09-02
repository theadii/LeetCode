class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length();

        Map<Character,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            Character c = magazine.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        int m = ransomNote.length();
        for(int i=0;i<m;i++){
            Character c = ransomNote.charAt(i);
            if(mp.containsKey(c) && mp.get(c)>0){
                mp.put(c,mp.get(c)-1);
            }
            else{
                return false;
            }
        }


        return true;
    }
}