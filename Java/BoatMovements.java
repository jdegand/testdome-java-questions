/* Note: This question has broken validation. */
public class BoatMovements {
    /**
     * @return boolean The destination is reachable or not
     */
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        boolean validMove = true;

        if (toRow < 0 || toColumn < 0 || toRow >= gameMatrix.length || toColumn >= gameMatrix[0].length ||
                fromRow < 0 || fromColumn < 0 || fromRow >= gameMatrix.length || fromColumn >= gameMatrix[0].length ||
                !gameMatrix[toRow][toColumn]) {
            validMove = false;
        } else if (fromRow == toRow) {
            if (toColumn < fromColumn - 1 || toColumn > fromColumn + 1) {
                validMove = false;
            } else if (toColumn == fromColumn + 1 && !gameMatrix[fromRow][fromColumn + 1]) {
                validMove = false;
            }
        } else if (toRow == fromRow - 1 || toRow == fromRow + 1) {
            if (toColumn != fromColumn) {
                validMove = false;
            }
        }
        
        return validMove;
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