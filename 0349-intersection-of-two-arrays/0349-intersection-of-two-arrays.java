class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int x : nums1){
            set.add(x);
        }

        Set<Integer> ans = new HashSet<>();

        for(int x : nums2){
            if(set.contains(x)){
                ans.add(x);
            }
        }

        int res[] = new int[ans.size()];
        int i = 0;
        for(int a : ans){
            res[i++] = a;
        }

        return res;
    }
}