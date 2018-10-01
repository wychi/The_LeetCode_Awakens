class Solution {
    //Time:O(MxN)
    //Space:O(MxN)
    //DFS
    public int numIslands(char[][] grid) {
        int number = 0;
        if (null == grid || grid.length <= 0)
            return number;
        
        for (int row = 0 ; row<grid.length; row++) {
            for (int col = 0; col<grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    number++;
                    checklands(grid, row, col);
                }
            }
        }
        return number;
    }
    
    private void checklands(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length)
            return;
        if (grid[row][col] == '0')
            return;
        
        grid[row][col] = '0';
        checklands(grid, row, col+1);
        checklands(grid, row, col-1);
        checklands(grid, row+1, col);
        checklands(grid, row-1, col);
    }
}
