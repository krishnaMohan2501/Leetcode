class NoIsland {
    public int numIslands(char[][] grid) {
        int noIsland =0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
               if(grid[row][col]=='1'){
                   noIsland+=1;
                   // bfs traversal
                   dfs(row,col,grid);
               }
            }
        }
        return noIsland;
    }
    
    private void dfs(int row, int col, char[][] grid){
        if(row<0 || row >=grid.length || col<0 ||col>= grid[row].length|| grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        dfs(row+1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
        dfs(row-1,col,grid);
    }
}
