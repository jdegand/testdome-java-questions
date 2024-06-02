import java.util.*;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        boolean[][] visited = new boolean[mapMatrix.length][mapMatrix[0].length];
        return dfs(fromRow, fromColumn, toRow, toColumn, mapMatrix, visited);
    }

    private static boolean dfs(int row, int col, int toRow, int toCol, boolean[][] mapMatrix, boolean[][] visited) {
        if (row < 0 || 
            col < 0 ||
            row >= mapMatrix.length || 
            col >= mapMatrix[0].length ||
            !mapMatrix[row][col] ||
            visited[row][col]
        ) {
            return false;
        }

        if (row == toRow && col == toCol) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(row + 1, col, toRow, toCol, mapMatrix, visited) || 
            dfs(row - 1, col, toRow, toCol, mapMatrix, visited) ||
            dfs(row, col + 1, toRow, toCol, mapMatrix, visited) ||
            dfs(row, col - 1, toRow, toCol, mapMatrix, visited)
        ) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                { true, false, false },
                { true, true, false },
                { false, true, true }
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
