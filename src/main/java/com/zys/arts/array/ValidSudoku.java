package com.zys.arts.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zys
 * @date: 2019/6/15 17:28
 */
public class ValidSudoku {


    /**
     * 数独的特性：
     * 1. Each row must contain the digits 1-9 without repetition.
     * 2. Each column must contain the digits 1-9 without repetition.
     * 3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * 所以解决这道题的核心思路在于：如何快速的判断出一个字符在当前行且当前列且当前所处的 3×3 小格内有无重复
     * <p>
     * 方法：借助哈希表（Set）的特性，快速判断字符有无重复
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        // 这里采用 Set 集合，
        // 利用 Set 集合的特性：
        // 1. 集合内元素不重复
        // 2. Set.add(a)：如果元素 a 不存在，加入到集合中，并返回 true，反之，则返回 false 且不加入到集合中
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                // 依照题意，数独的空单元格可以用 '.' 来填充，所以这里要忽略 '.'
                if (number != '.') {
                    // 这里为了便于阅读与理解，我们可以将 board[i][j] 的值进行处理
                    // 假设 board[0][0] = 1，那么 "1 in row 0" 这个字符串值就可以表示 board[0][0] 在当前行的值；
                    // "1 in column 0" 这个字符串值就可以表示 board[0][0] 在当前列的值；
                    // "1 in block 0-0" 这个字符串值就可以表示 board[0][0] 在当前 3×3 小格内的值。
                    // 这样就不需要借助额外的 set 集合来区分 行、列以及 3×3 的小格了
                    // 当然也可以使用三个 set 集合，分别进行区分，不过我觉得现在的实现方法，可读性更高，代码更简短。
                    if (!seen.add(number + " in row " + i)
                            || !seen.add(number + " in column " + j)
                            || !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }


    /**
     * 这个解法也挺有意思的，利用数组来做
     * 理解难点在于 smallSeen 这个数组设计，这个是三维数组 smallSeen[x][y][z]，
     * 其中x，y 其实可以理解为 3×3 的小格的坐标，而 z 则是数值对应的偏移量，这样去理解会比较容易懂
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9];
        boolean[][][] smallSeen = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit == '.') {
                    continue;
                }
                int index = digit - '0' - 1;
                if (row[i][index]) {
                    return false;
                }
                row[i][index] = true;
                if (col[j][index]) {
                    return false;
                }
                col[j][index] = true;
                int x = i / 3, y = j / 3;
                if (smallSeen[x][y][index]) {
                    return false;
                }
                smallSeen[x][y][index] = true;
            }
        }
        return true;
    }
}
