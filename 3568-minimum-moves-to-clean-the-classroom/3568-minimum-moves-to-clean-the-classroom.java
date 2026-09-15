class Solution {

    static class State {
        int r, c, energy, mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;

        int[][] litterId = new int[m][n];

        for (int[] row : litterId)
            Arrays.fill(row, -1);

        int litterCount = 0;

        // Locate start and assign IDs to litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int allMask = (1 << litterCount) - 1;

        /*
            visited[row][col][energy][mask]
        */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<State> q = new ArrayDeque<>();

        q.offer(new State(sr, sc, energy, 0));
        visited[sr][sc][energy][0] = true;

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                State cur = q.poll();

                int r = cur.r;
                int c = cur.c;
                int e = cur.energy;
                int mask = cur.mask;

                if (mask == allMask)
                    return moves;

                if (e == 0)
                    continue;

                for (int[] dir : dirs) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n)
                        continue;

                    if (classroom[nr].charAt(nc) == 'X')
                        continue;

                    int newEnergy = e - 1;
                    int newMask = mask;

                    // Collect litter
                    if (litterId[nr][nc] != -1) {
                        newMask |= (1 << litterId[nr][nc]);
                    }

                    // Recharge
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(
                            new State(
                                nr,
                                nc,
                                newEnergy,
                                newMask
                            )
                        );
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}