class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> mp = new HashMap<>();
        Map<Character,Integer> mp2 = new HashMap<>();

        int n = secret.length();
        int m = guess.length();
        int a = 0;
        for(int i=0;i<n;i++){
           Character c =secret.charAt(i);
            if(c == guess.charAt(i)){
                a++;
                continue;
            }
           mp.put(c,mp.getOrDefault(c,0)+1);
            
        }
        int b = 0;
        for(int i=0;i<m;i++){
            Character c = guess.charAt(i);

            if(c == secret.charAt(i)){
                continue;
            }

            if(mp.containsKey(c) && mp.get(c)>0){
                b++;
                mp.put(c,mp.get(c)-1);
            }
        }

        String ans = a + "A" + b + "B";

        return ans;

    }
}