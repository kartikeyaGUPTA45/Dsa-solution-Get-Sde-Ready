class Solution {

    private boolean isQueenSafe(int row, int col, int n, boolean board[][]) {
        // for d1 => r--,c--
        for(int r = row-1,c=col-1;r>=0 && c>=0; r--,c--) {
            if (board[r][c] == true) {
                return false;
            }
        }

        // for d2 => r--,c-> constant
        for(int r=row-1;r>=0;r--) {
            if (board[r][col] == true) {
                return false;
            }
        }

        // for d3 => r--,c++
        for(int r=row-1,c=col+1;r>=0 && c<n;r--,c++) {
            if (board[r][c] == true) {
                return false;
            }
        }

        return true;
    }

    private void prepareBoard(boolean board[][], List<List<String>> ans, int n) {
        List<String> subAns = new ArrayList<>();
        for(int row=0;row<n;row++) {
            StringBuilder sb = new StringBuilder();
            for(int col=0;col<n;col++) {
                if (board[row][col] == true) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            subAns.add(sb.toString());            
        }
        ans.add(new ArrayList<>(subAns));
    }

    private void helper(int row, boolean board[][], int n, List<List<String>> ans) {
        if (row == n) {
            prepareBoard(board,ans,n);
            return;
        }

        for(int col = 0;col<n;col++) {
            if (isQueenSafe(row,col,n,board) == true) {
                board[row][col] = true;
                helper(row+1,board,n,ans);
                board[row][col] = false;
            } 
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean board[][] = new boolean[n][n];
        helper(0,board,n,ans);
        return ans;
    }
}
