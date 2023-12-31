public class Queens {

    private int[][] board;
    private int size;

    public Queens(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private boolean solve(int col) {
        if (col >= size) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (solve(col + 1)) {
                    return true;
                }

                board[i][col] = 0; // backtrack
            }
        }

        return false;
    }

    public boolean solveNQueens() {
        if (!solve(0)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution();
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
