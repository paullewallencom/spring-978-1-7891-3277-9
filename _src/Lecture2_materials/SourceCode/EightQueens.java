package com.loonycorn;

/**
 * Created by jananiravi on 11/19/15.
 */
public class EightQueens {

    private static final int N = 8;

    public static void main(String[] args) {
        int chessBoard[][] = new int[N][N];

        placeQueen(chessBoard, 0);
        print(chessBoard);
    }

    public static void print(int[][] chessBoard) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean placeQueen(int[][] chessBoard, int col) {
        if (col >= N) {
            return true;
        }

        for (int row = 0; row < N; row++) {
            chessBoard[row][col] = 1;
            if (isSafe(chessBoard, row, col)) {
                if (placeQueen(chessBoard, col + 1)) {
                    return true;
                }
            }
            chessBoard[row][col] = 0;
        }

        return false;
    }

    public static boolean isSafe(int[][] chessBoard, int row, int col) {
        if (!isColumnSafe(chessBoard, col)) {
            return false;
        }
        if (!isRowSafe(chessBoard, row)) {
            return false;
        }
        if (!isLeftDiagonalSafe(chessBoard, row, col)) {
            return false;
        };

        return isRightDiagonalSafe(chessBoard, row, col);
    }

    private static boolean isRightDiagonalSafe(int[][] chessBoard, int row, int col) {
        int rightDiagSum = 0;
        int r = 0;
        int c = 7;
        if (row + col < N) {
            c = Math.min(row + col, N - 1);
        } else {
            r = (row + col) % (N - 1);
        }
        while (r < N && c >= 0) {
            rightDiagSum += chessBoard[r++][c--];
        }

        return rightDiagSum == 1;
    }

    private static boolean isLeftDiagonalSafe(int[][] chessBoard, int row, int col) {
        // Check if there is another queen in the same left diagonal.
        int leftDiagSum = 0;
        int r = 0;
        int c = 0;
        if (row > col) {
            r = row - col;
        } else {
            c = col - row;
        }
        while (r < N && c < N) {
            leftDiagSum += chessBoard[r++][c++];
        }

        return leftDiagSum == 1;
    }

    private static boolean isColumnSafe(int[][] chessBoard, int col) {
        int colSum = 0;
        // Check if there is another queen in the same column.
        for (int r = 0; r < N; r++) {
            colSum += chessBoard[r][col];
        }

        return colSum == 1;
    }

    private static boolean isRowSafe(int[][] chessBoard, int row) {
        int rowSum = 0;
        // Check if there is another queen in the same row.
        for (int c = 0; c < N; c++) {
            rowSum += chessBoard[row][c];
        }

        return rowSum == 1;
    }
}
