class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> mp = new HashMap<>();

        for(List<String> x : knowledge){
            String key = x.get(0);
            String val = x.get(1);
            mp.put(key,val);
        }

        StringBuilder ans = new StringBuilder();

        int i=0;
        int n = s.length();

        while(i<n){

            if(s.charAt(i) != '('){
                ans.append(s.charAt(i));
            }
            else{
                StringBuilder key = new StringBuilder();
                i++;
                while(i < n && s.charAt(i) !=')'){
                    key.append(s.charAt(i));
                    i++;
                }
                if(mp.containsKey(key.toString())){
                    ans.append(mp.get(key.toString()));
                }
                else{
                    ans.append('?');
                }
            }
            i++;

        }
        return ans.toString();




    }
}