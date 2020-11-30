package DFS;

/**
 * @author 彭一鸣  200. 岛屿数量  https://leetcode-cn.com/problems/number-of-islands/
 * @since 2020/11/30 9:03
 */
public class 岛屿数量 {
    int sum;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        function(grid);
        return sum;
    }

    private void function(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                    dfs(i, j, grid);
                }
            }
         }
     }


    private void dfs(int i, int j, char[][] grid) {
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        if (i > 0) dfs(i - 1, j, grid);
        if (i < grid.length - 1) dfs(i + 1, j, grid);
        if (j > 0) dfs(i, j - 1, grid);
        if (j < grid[0].length - 1) dfs(i, j + 1, grid);
    }
}
