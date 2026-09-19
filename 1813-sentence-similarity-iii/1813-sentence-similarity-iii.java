class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int n = s1.length;
        int m = s2.length;

        // Make s1 the longer sentence
        if (n < m) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;

            n = s1.length;
            m = s2.length;
        }

        // Match from left
        int l = 0;
        
        while (l < m  && s1[l].equals(s2[l])) {
            l++;
        }

        // Match from right
        int r1 = n - 1;
        int r2 = m - 1;

        while (r2 >= l && s1[r1].equals(s2[r2])) {
            r1--;
            r2--;
        }

        return r2 < l;
    }
}