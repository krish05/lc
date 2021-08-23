 public boolean exist(char[][] board, String word) {
        Set<String> path = new HashSet<String>();
        for(int r=0; r<getRows(board); r++) {
            for(int c=0; c<getColumns(board); c++) {
                if(patternExists(board,path,word, r,c,0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean patternExists(char[][] board, Set<String> path, String word, int r, int c, int i) {
        if(i==word.length()) {
            return true;
        }
        if(r<0 || r>=getRows(board) ||
          c<0 || c>=getColumns(board) ||
          board[r][c] != word.charAt(i) ||
          path.contains(r+","+c)) {
            return false;
        }
        path.add(r+","+c);
        boolean res = patternExists(board, path, word, r-1, c, i+1) ||
                        patternExists(board, path, word, r+1, c, i+1) ||
                        patternExists(board, path, word, r, c-1, i+1) ||
                        patternExists(board, path, word, r, c+1, i+1);
        path.remove(r+","+c);
        return res;
    }
    
    private int getRows(char[][] board) {
        return board.length;
    }
    private int getColumns(char[][] board) {
        return board[0].length;
    }
