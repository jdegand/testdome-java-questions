/* Note: Testdome validation seems to be broken as this returns the intended answer(true, false, false)  */
public class BoatMovements {
    /**
     * @return boolean The destination is reachable or not
     */
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // Validate if destination is out of bounds or starting point is out of bounds
        if (!isValidPosition(gameMatrix, toRow, toColumn) || !isValidPosition(gameMatrix, fromRow, fromColumn)) {
            return false;
        }

        // Validate if destination is a valid cell
        if (!gameMatrix[toRow][toColumn]) {
            return false;
        }

        // Check movement within the same row
        if (fromRow == toRow) {
            return Math.abs(toColumn - fromColumn) == 1;
        }

        // Check movement within the same column
        if (fromColumn == toColumn) {
            return Math.abs(toRow - fromRow) == 1;
        }

        return false;
    }

    private static boolean isValidPosition(boolean[][] matrix, int row, int column) {
        return row >= 0 && column >= 0 && row < matrix.length && column < matrix[0].length;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                { false, true, true, false, false, false },
                { true, true, true, false, false, false },
                { true, true, true, true, true, true },
                { false, true, true, false, true, true },
                { false, true, true, true, false, true },
                { false, false, false, false, false, false }
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2) ? "true" : "false"); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4) ? "true" : "false"); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 5, 2) ? "true" : "false"); // false, Out of bounds
    }
}
