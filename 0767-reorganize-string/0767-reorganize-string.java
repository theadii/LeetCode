class Solution {
    class pair{
        int freq;
        char c;

        pair(char c, int f){
            this.c = c;
            freq = f;
        }
    }
    public String reorganizeString(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));

        for(Map.Entry<Character,Integer> x : mp.entrySet()){
            pq.offer(new pair(x.getKey(),x.getValue()));
        }
        StringBuilder ans = new StringBuilder();
        while(pq.size()>1){
            pair t1 = pq.poll();
            pair t2 = pq.poll();

            t1.freq -=1;
            t2.freq -=1;

            ans.append(t1.c);
            ans.append(t2.c);

            if(t1.freq > 0) pq.offer(t1);
            if(t2.freq > 0) pq.offer(t2);

        }

        if(pq.size() ==  1){
            if(pq.peek().freq == 1){
                ans.append(pq.peek().c);
            }
            else{
                return "";
            }
        }
        

        return ans.toString();

        
    }
}