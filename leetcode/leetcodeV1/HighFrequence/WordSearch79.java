package HighFrequence;

public class WordSearch79 {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;

        board[y][x] ^= 256;

        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);

        board[y][x] ^= 256;

        return exist;
    }
    //board[y][x] ^= 256 it's a marker that the letter at position x,y is a part of word we search.
    //After board[y][x] ^= 256 the char became not a valid letter. After second board[y][x] ^= 256
    //it became a valid letter again.


    //restriction is '*' cannot be present in the input char matrix.
    public boolean existSec(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) return true;
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, ind + 1) ||
                exist(board, i, j - 1, word, ind + 1) ||
                exist(board, i, j + 1, word, ind + 1) ||
                exist(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }
}
