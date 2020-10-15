package 回溯;

import java.util.ArrayList;
import java.util.List;

// 51. N 皇后 https://leetcode-cn.com/problems/n-queens/
public class N皇后 {
    List<List<String>> result;
    // queen[row]表示第row行第queen[row]列是皇后
    int[] queen;
    // 表示这一列有无皇后
    boolean[] cols;
    // 表示有多少种摆法
    static int count;
    // 表示斜率为-1的这一斜线有无皇后,一共有2*n-1条斜线
    /*
    row\col 0 1 2

        0   2 3 4
        1   1 2 3   不难看出棋盘索引index = col - row + 2,通解是col - row + n - 1
        2   0 1 2
     */
    boolean[] _k;
    // 表示斜率为-1的这一斜线有无皇后,一共有2*n-1条斜线
    /*
    row\col 0 1 2

        0   0 1 2
        1   1 2 3   不难看出棋盘索引index = col + row
        2   2 3 4
     */
    boolean[] k;

    public static void main(String[] args) {
        List<List<String>> list = new N皇后().solveNQueens(8);
        System.out.println(list);
    }
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        // 初始化皇后棋盘
        queen = new int[n];
        cols = new boolean[n];
        _k = new boolean[(n << 1) - 1];
        k = new boolean[(n << 1) - 1];
        // 摆放第0行的皇后
        place(0);
        return result;
    }

    // 摆放第row行的皇后
    public void place(int row) {
        //判断这一行的位置是否能放皇后,i表示列的位置一直从左到右遍历
        for (int i = 0; i < queen.length; i++) {
            // 如果不能放皇后则判断这一行的下一列是否能放皇后
            if (cols[i]) continue;
            int _kIndex = i - row + queen.length - 1;
            if (_k[_kIndex]) continue;
            int kIndex = i + row;
            if (k[kIndex]) continue;
            // 如果进入到这里则说明可以放皇后
            queen[row] = i; // 表示第row行第queen[i]列是皇后
            // 满足这个条件说明这是放的最后一个皇后，即一条路线
            if (row == queen.length - 1) {
                count++;
                // 打印皇后
                addResult(queen);
            }
            // 将皇后的列，斜线全部定义为true，表示处于那个位置的不能放皇后
            cols[i] = true;
            _k[_kIndex] = true;
            k[kIndex] = true;
            // 摆放完成之后继续摆放下一行
            place(row + 1);
            // 如果失败，回溯，将原来的true改为false;
            cols[i] = false;
            _k[_kIndex] = false;
            k[kIndex] = false;
        }
    }
    void addResult(int[] queen) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < queen.length; i++) {
            String row = "";
            for (int j = 0; j < queen.length; j++) {
                if (queen[i] == j) {
                    row = row + "Q";
                } else {
                    row = row + ".";
                }
            }
            list.add(row);
        }
        result.add(list);
    }
}

