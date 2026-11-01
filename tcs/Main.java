import java.util.*;

public class Main {

    static class Move {
        String dir;
        int dist;
        Move(String d, int x) { dir = d; dist = x; }
    }

    static final int[] DX = {0, 1, 0, -1}; // north, east, south, west
    static final int[] DY = {1, 0, -1, 0};

    static int adjustDir(int cur, String instr) {
        if ("left".equals(instr)) return (cur + 3) % 4;
        if ("right".equals(instr)) return (cur + 1) % 4;
        return cur; // straight
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        Move[] moves = new Move[n];
        for (int i = 0; i < n; i++) {
            String d = sc.next().toLowerCase();
            int x = sc.nextInt();
            moves[i] = new Move(d, x);
        }
        long sx = sc.nextLong(), sy = sc.nextLong();
        long tx = sc.nextLong(), ty = sc.nextLong();
        sc.close();

        // Original path check
        if (reachesTarget(moves, sx, sy, tx, ty)) {
            System.out.print("Yes\nNo change needed");
            return;
        }

        // Precompute prefix positions and directions
        long[] px = new long[n + 1];
        long[] py = new long[n + 1];
        int[] dirAfter = new int[n + 1];
        px[0] = sx; py[0] = sy; dirAfter[0] = 0;

        for (int i = 0; i < n; i++) {
            int curDir = dirAfter[i];
            int newDir = adjustDir(curDir, moves[i].dir);
            px[i + 1] = px[i] + DX[newDir] * (long) moves[i].dist;
            py[i + 1] = py[i] + DY[newDir] * (long) moves[i].dist;
            dirAfter[i + 1] = newDir;
        }

        // Suffix displacement table
        long[][] suffDx = new long[n + 1][4];
        long[][] suffDy = new long[n + 1][4];
        for (int k = n - 1; k >= 0; k--) {
            for (int s = 0; s < 4; s++) {
                int nd = adjustDir(s, moves[k].dir);
                long pdx = DX[nd] * (long) moves[k].dist;
                long pdy = DY[nd] * (long) moves[k].dist;
                suffDx[k][s] = pdx + suffDx[k + 1][nd];
                suffDy[k][s] = pdy + suffDy[k + 1][nd];
            }
        }

        String[] cand = {"straight", "left", "right"};
        for (int i = 0; i < n; i++) {
            int beforeDir = dirAfter[i];
            for (String nd : cand) {
                if (nd.equals(moves[i].dir)) continue;
                int newDirAfter = adjustDir(beforeDir, nd);
                long pdx = DX[newDirAfter] * (long) moves[i].dist;
                long pdy = DY[newDirAfter] * (long) moves[i].dist;
                long sdx = suffDx[i + 1][newDirAfter];
                long sdy = suffDy[i + 1][newDirAfter];
                long finalX = px[i] + pdx + sdx;
                long finalY = py[i] + pdy + sdy;
                if (finalX == tx && finalY == ty) {
                    System.out.print("Yes\n" + moves[i].dir + " " + moves[i].dist + "\n" + nd + " " + moves[i].dist);
                    return;
                }
            }
        }

        System.out.print("No");
    }

    static boolean reachesTarget(Move[] moves, long sx, long sy, long tx, long ty) {
        long x = sx, y = sy;
        int dir = 0;
        for (Move m : moves) {
            dir = adjustDir(dir, m.dir);
            x += DX[dir] * (long) m.dist;
            y += DY[dir] * (long) m.dist;
        }
        return x == tx && y == ty;
    }
}
