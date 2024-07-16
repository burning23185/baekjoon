import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static class Position{
        private final int x;
        private final int y;
        private final int time;

        public Position(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.time = t;
        }
        public Position(int x, int y){
            this.x = x;
            this.y = y;
            this.time = 0;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public int getTime() {
            return time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[][] map = new int[m][n];
        int num;
        int yet_tomato_cnt = 0;
        Queue<Position> q = new LinkedList<>();
        String[] line;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            line =  br.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                num = Integer.parseInt(line[j]);
                map[i][j] = num;
                if(num == 0) yet_tomato_cnt++;
                else if(num == 1) {
                    q.offer(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }
        Position now;

        Position[] dirs = new Position[]{new Position(0,1), new Position(1,0), new Position(0,-1), new Position(-1,0)};

        int nx, ny;
        int ans = 0;

        while(q.size() > 0){
            now = q.poll();
            ans = Math.max(ans, now.getTime());

            for(Position dir : dirs){
                nx = now.getX() + dir.getX();
                ny = now.getY() + dir.getY();
                if(nx < 0 || ny < 0 || nx >= m || ny >= n ) continue;
                if(map[nx][ny] == -1 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                yet_tomato_cnt--;
                q.offer(new Position(nx, ny, now.getTime() + 1));
            }
        }
        System.out.println(yet_tomato_cnt == 0 ? ans : -1);
    }
}