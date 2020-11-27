package 回溯;

import java.util.Arrays;

/**
 * @author 彭一鸣  79. 单词搜索    https://leetcode-cn.com/problems/word-search/
 * @since 2020/11/26 19:32
 */
public class 单词搜索 {

    private boolean result;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        char toFindLetter = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (toFindLetter == board[i][j]) {
                    if (word.length() > 1) {
                        boolean[][] used = new boolean[board.length][board[0].length];
                        used[i][j] = true;
                        dfs(board, new int[] {i, j}, 1, word, used);
                    }
                    else {
                        return true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 从cur[0][1]开始寻找下一个字母word.charAt(i)
     * @param board
     * @param cur
     * @param i
     * @param word
     * @param used
     * @return
     */
    private void dfs(char[][] board, int[] cur, int i, String word, boolean[][] used) {
        if (cur == null) return;
        if (i == word.length()) {
            result = true;
            return;
        }
        int[] find = findLetter(board, cur, i, word);
        for (int j = 0; j < find.length; j++) {
            if (find[j] != -1 && !result) {
                if (!used[find[j]][find[j + 1]]) {
                    System.out.println(j + "," + j + 1);
                    used[find[j]][find[j + 1]] = true;
                    dfs(board, new int[]{find[j], find[j + 1]}, i + 1, word, used);
                    used[find[j]][find[j + 1]] = false;
                }
                j++;
            }
        }
        return;
    }

    /**
     * 探测周围有没有这个字母，有就返回它的坐标
     * @param board 棋盘
     * @param cur   当前左边
     * @param i 下一个要寻找的字母索引
     * @return  返回寻找到字母的坐标
     */
    private int[] findLetter(char[][] board, int[] cur, int i, String word) {
        int[] find = new int[8];
        for (int j = 0; j < find.length; j++) {
            find[j] = -1;
        }
        if (i >= word.length()) {
            return null;
        }
        char c = word.charAt(i);
        // 上
        if (cur[0] > 0 && board[cur[0] - 1][cur[1]] == c) {
            find[0] = cur[0] - 1;
            find[1] = cur[1];
        }
        // 下
        if (cur[0] < board.length - 1 && board[cur[0] + 1][cur[1]] == c) {
            find[2] = cur[0] + 1;
            find[3] = cur[1];
        }
        // 左
        if (cur[1] > 0 && board[cur[0]][cur[1] - 1] == c) {
            find[4] = cur[0];
            find[5] = cur[1] - 1;
        }
        // 右
        if (cur[1] < board[0].length - 1 && board[cur[0]][cur[1] + 1] == c) {
            find[6] = cur[0];
            find[7] = cur[1] + 1;
        }
        return find;
    }

}
