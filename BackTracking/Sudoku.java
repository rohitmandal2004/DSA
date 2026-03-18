public class Sudoku {

    public static boolean isSafe(char[][] board, int row, int col, char num) {
        // row check
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // 3x3 grid check
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public static boolean solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // find empty cell
                if (board[i][j] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, i, j, num)) {

                            board[i][j] = num; // place

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[i][j] = '.'; // backtrack
                        }
                    }

                    return false; // no valid number
                }
            }
        }

        return true; // solved
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
        printBoard(board);
    }
}