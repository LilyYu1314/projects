package MathSummary.ArraySummary;

public class BattleshipsinaBoard_419 {
    //Going over all cells, we can count only those that are the "first" cell of the battleship.
    //First cell will be defined as the most top-left cell.
    //We can check for first cells by only counting cells that do not have an 'X' to the left and do not have an 'X' above them.

    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }

        return count;
    }

    //需要写个测试用例
}
