class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
        boolean flag = false;
        for(int i=0;i<invocations.length;i++){
            if(!mp.containsKey(invocations[i][0])){
                mp.put(invocations[i][0],new ArrayList<>());
            }
            
            mp.get(invocations[i][0]).add(invocations[i][1]);
        }


        Set<Integer> sus = new HashSet<>();
        sus.add(k);
        Queue<Integer> q = new LinkedList<>();

        q.offer(k);

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int x : mp.getOrDefault(curr,new ArrayList<>())){
                if(!sus.contains(x)){
                    sus.add(x);
                    q.offer(x);
                }
            }
        }
        
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<n;i++){
            int key = i;
            
            if(!sus.contains(key)){
                ans.add(key);
                if(mp.containsKey(key)){
                    for(int v : mp.get(key)){
                        if(sus.contains(v)){
                            flag = true;
                        }
                        ans.add(v);
                    }
                }
            }

        }
        
        List<Integer> result = new ArrayList<>();
        if(flag){
            for(int i=0;i<n;i++){
                result.add(i);
            }
            return result;
        }
        result = new ArrayList<>(ans);

        return result;


    }
}