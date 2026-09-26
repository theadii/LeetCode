class Solution {

    int solve(int n) {

        if (n == 0) {
            return 0;
        }

        int p = 1;

        while (p < n) {
            p *= 2;
        }

        // n itself is a power of 2
        if (p == n) {
            return 1;
        }

        int lower = p / 2;

        // Use lower power or higher power
        return 1 + Math.min(
            solve(n - lower),
            solve(p - n)
        );
    }

    public int minOperations(int n) {
        return solve(n);
    }
}