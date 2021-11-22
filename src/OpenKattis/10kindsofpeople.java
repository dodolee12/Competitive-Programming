package OpenKattis;

import java.util.Scanner;

class tenkindsofpeople {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];
        for (int i = 0; i < r; ++i) {
            String row = sc.next();
            for (int j = 0; j < c; ++j) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;

            boolean[][] visited = new boolean[r][c];

            if (grid[r1][c1] == grid[r2][c2] && solve(grid, visited, r1, c1, r2, c2, grid[r1][c1])) {
                System.out.println(grid[r1][c1] == 1 ? "decimal" : "binary");
            } else {
                System.out.println("neither");
            }
        }
    }

    private static boolean solve(int[][] grid, boolean[][] visited, int r1, int c1, int r2, int c2, int start) {
        if (r1 < 0 || r1 >= grid.length || c1 < 0 || c1 >= grid[0].length || visited[r1][c1] || grid[r1][c1] != start) {
            return false;
        }
        if (r1 == r2 && c1 == c2) {
            return true;
        }
        visited[r1][c1] = true;
        return solve(grid, visited, r1 - 1, c1, r2, c2, start) || solve(grid, visited, r1 + 1, c1, r2, c2, start)
                || solve(grid, visited, r1, c1 - 1, r2, c2, start) || solve(grid, visited, r1, c1 + 1, r2, c2, start);
    }
}
