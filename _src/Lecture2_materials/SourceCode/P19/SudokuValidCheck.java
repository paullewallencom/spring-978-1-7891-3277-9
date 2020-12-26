import java.util.*;

/**
 * Created by jananiravi on 11/7/15.
 */
public class SudokuValidCheck {

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {-1, -1, -1, -1, -1,  1, -1,  9, -1},
                { 1, -1, -1, -1, -1, -1,  2, -1,  3},
                { 2, -1,  3, -1, -1, -1, -1,  7, -1},

                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                { 3, -1, -1, -1,  7, -1,  4, -1,  5},
                { 4, -1,  5, -1, -1,  2, -1,  8, -1},

                {-1, -1, -1, -1, -1, -1, -1,  4, -1},
                { 5, -1, -1, -1, -1, -1,  6, -1,  7},
                { 6, -1,  7, -1, -1, -1, -1,  5, -1},
        };

        System.out.println(String.format("Is the board valid: %s", isValid(board)));
    }

    /**
     * This checks whether a Sudoku board that is passed in is valid. A board is valid when no row or column contains
     * any of the numbers 1-9 more than once. Also every 3x3 group of 9 cells should not contain any of the
     * numbers from 1-9 more than once.
     * @param sudokuBoard
     * @return
     */
    public static boolean isValid(int[][] sudokuBoard) {
        // Check whether all rows and columns have unique numbers 1-9. We will use a set to check
        // whether the number has been added before in that row or column.
        if (!isValidRowsAndColumns(sudokuBoard)) {
            return false;
        }

        // Now check each 3x3 block to see if the numbers between 1-9 are repeated within that block.
        // Assume the 3x3 blocks are numbered as follows
        // 0-1-2
        // 3-4-5
        // 6-7-8
        if (!isValidBlocks(sudokuBoard)) {
            return false;
        }

        // If we fall through here then all our checks indicate that the board is valid.
        return true;
    }

    private static boolean isValidBlocks(int[][] sudokuBoard) {
        // Have an integer set associated with each to check whether a number in that cell
        // has occurred in the block before.
        List<Set<Integer>> blockList = new ArrayList<Set<Integer>>();
        for (int i = 0; i < 9; i++) {
            blockList.add(new HashSet<Integer>());
        }

        for (int rowBlock = 0; rowBlock < 3; rowBlock++) {
            for (int colBlock = 0; colBlock < 3; colBlock++) {
                // Here we iterate over the cells in each block.
                for (int miniRow = 0; miniRow < 3; miniRow++) {
                    for (int miniCol = 0; miniCol < 3; miniCol++) {
                        // This calculation gives us the actual cell in the sodoku board.
                        // Since each block is a 3x3 block and the mini rows and columns are
                        // rows and columns in that block this moves us to the right row and
                        // the right cell within it.
                        int row = rowBlock * 3 + miniRow;
                        int col = colBlock * 3 + miniCol;

                        int cellValue = sudokuBoard[row][col];
                        // If no value has been assigned to a cell then continue, don't perform
                        // any checks.
                        if (cellValue == -1) {
                            continue;
                        }
                        if (cellValue < 1 || cellValue > 9) {
                            return false;
                        }
                        int blockNumber = rowBlock * 3 + colBlock;
                        if (blockList.get(blockNumber).contains(cellValue)) {
                            return false;
                        }
                        blockList.get(blockNumber).add(cellValue);
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidRowsAndColumns(int[][] sudokuBoard) {
        // Set up a list of sets one for each row and one for each column.
        List<Set<Integer>> rowList = new ArrayList<Set<Integer>>();
        List<Set<Integer>> columnList = new ArrayList<Set<Integer>>();

        // Initialize a set associated with each row and column.
        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<Integer>());
            columnList.add(new HashSet<Integer>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Get the value in that sudoku cell.
                int cellValue = sudokuBoard[row][col];
                // If no value has been assigned to a cell then continue, don't perform any checks.
                if (cellValue == -1) {
                    continue;
                }
                if (cellValue < 1 || cellValue > 9) {
                    return false;
                }

                // If the value has been seen in that row or column before return false.
                if (rowList.get(row).contains(cellValue)) {
                    return false;
                }
                if (columnList.get(col).contains(cellValue)) {
                    return false;
                }

                // Add the current cell value to the row or column set.
                rowList.get(row).add(cellValue);
                columnList.get(col).add(cellValue);
            }
        }
        return true;
    }


}
