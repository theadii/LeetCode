class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int j = 0;

        for (int i = 0; i < n && j < m; i++) {

            char c = str1.charAt(i);
            char c2 = str2.charAt(j);

            if (c == c2 || c + 1 == c2 || (c == 'z' && c2 == 'a')) {
                j++;
            }
        }

        return j == m;
    }
}