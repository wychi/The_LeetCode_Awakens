class Solution {
    public boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row =0; row < board.length; row++) {
            for (int col =0; col<board[0].length; col++) {
                if (charArray[0] == board[row][col]) {
                    if (search(board, charArray, visited, row, col, 0))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, char[] charArray, boolean[][] visited, int row, int col, int indexOfWord) {
        if (indexOfWord == charArray.length) {
            return true;
        }
        if (row < 0 || col < 0
            || row>=board.length || col >= board[0].length) {
            return false;
        }
        if (visited[row][col] || charArray[indexOfWord] != board[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean exist = search(board, charArray, visited, row, col+1, indexOfWord+1) ||
                        search(board, charArray, visited, row, col-1, indexOfWord+1) ||
                        search(board, charArray, visited, row+1, col, indexOfWord+1) ||
                        search(board, charArray, visited, row-1, col, indexOfWord+1);
        visited[row][col] = false;
        return exist;
    }
}
