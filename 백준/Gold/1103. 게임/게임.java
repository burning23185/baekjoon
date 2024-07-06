import java.io.*;

public class Main {
    private static int[][] map;
    private static int[][] dp;
    private static boolean[][] visited;
    private static Position[] dir;
    private static int res;
    private static class Position{
        private final int x;
        private final int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

    }
    private static void dfs(Position now, int count){
        int val = map[now.getX()][now.getY()];
        int nx, ny;
        if(res == -1) return;
        dp[now.getX()][now.getY()] = count;
        res = Math.max(res, count);

        for(Position d : dir){

            nx = now.getX() + val*d.getX();
            ny = now.getY() + val*d.getY();

            if(nx < 0 || ny  < 0 || nx >= map.length || ny >= map[0].length) continue;

            if(visited[nx][ny]) {
                res = -1;
                return ;
            }
            if(map[nx][ny] == -1) continue;
            if(dp[nx][ny] > count) continue;

            visited[nx][ny] = true;
            dfs(new Position(nx, ny), count+1);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        dir = new Position[]{
                new Position(0,1), new Position(1,0), new Position(0,-1), new Position(-1,0)
        };

        dp = new int[n][m];
        map = new int[n][m];
        visited = new boolean[n][m];
        res = 0;
        String temp;
        for(int i = 0 ; i < n ; i++){
            temp = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = (temp.charAt(j) == 'H') ? -1 : (temp.charAt(j) - '0');
            }
        }

        dfs(new Position(0,0),1);
        System.out.println(res);

        br.close();
    }
}