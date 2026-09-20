class Solution {

    class pair{
        int x;
        int y;

        pair(int i,int j){
            x = i;
            y = j;
        }
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int board[][] = new int[8][8];
        int n = queens.length;
        for(int i=0;i<n;i++){
            int x = queens[i][0];
            int y = queens[i][1];
            board[x][y] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int kx = king[0];
        int ky = king[1];

        int i=kx;
        int j = ky;
        // diagonal up left
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            i--;
            j--;
        }

        i = kx;
        j = ky;
        //diagonal down rigth
        while(i<8 && j<8){
            
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            i++;
            j++;
        }
        i= kx;
        j = ky;
        // left
        while(i>=0 ){
            
        
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            i--;
        }

        i = kx;
        j = ky;
        //diagonal down left
        while(i<8 && j>=0){
            
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            i++;
            j--;
        }

        i = kx;
        j = ky;
        //diagonal up right
        while(i>=0 && j<8){
            
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            i--;
            j++;
        }

        i = kx;
        j = ky;

        // right
        while(i<8 ){
            
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            i++;
            
        }


        i = kx;
        j = ky;

        //down
        while(j<8){
            
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            
            j++;
        }

        i = kx;
        j = ky;

        //up
        while(j>=0){
            
            if(board[i][j]==1){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                ls.add(j);
                ans.add(ls);
                break;
            }
            
            j--;
        }

        return ans;

        

        
    }
}