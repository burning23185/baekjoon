import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int[][] map;
    private static int[][] dp;
    private static final Position[] dir = {
            new Position(0,1), new Position(1,0), new Position(0,-1), new Position(-1,0)
    };

    private static class Position{
        private int x;
        private int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }
    public static int dfs(Position now) {
        if (now.getX() == map.length-1 && now.getY() == map[0].length-1) return 1;
        if(dp[now.getX()][now.getY()] >= 0) return dp[now.getX()][now.getY()];

        //방문 기록
        dp[now.getX()][now.getY()] = 0;
        int nx, ny;

        for (Position p : dir) {
            nx = now.getX() + p.getX();
            ny = now.getY() + p.getY();

            if (nx < 0 || ny < 0 || nx > map.length-1 || ny > map[0].length-1) continue;
            if (map[now.getX()][now.getY()] <= map[nx][ny]) continue;

            dp[now.getX()][now.getY()] += dfs(new Position(nx, ny));
        }
        return dp[now.getX()][now.getY()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        map = new int[n][m];
        dp = new int[n][m];

        for (int i=0 ; i < n ; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j=0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(new Position(0, 0)));
    }
}