import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Position[] direction = new Position[]{
            new Position(0,1), new Position(1,0), new Position(0,-1), new Position(-1,0)};
    private static int[][] map;
    private static List<Position> virus;
    private static int blink_num;
    private static int ans = 0;

    public static class Position{
        private int x;
        private int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }

    // 벽을 다 세운 후 바이러스를 퍼뜨려 남은 빈 공간을 확인
    private static void spreadVirus(int[][] changed_map){
        int temp_blink_num = blink_num - 3;
        int next_x, next_y;

        Queue<Position> q = new LinkedList<>();
        for(Position v : virus) q.offer(v);

        Position now;

        while (q.size() > 0){
            now = q.poll();

            for(Position d : direction) {
                next_x = now.getX() + d.getX();
                next_y = now.getY() + d.getY();

                if (next_x < 0 || next_y < 0 || next_x >= changed_map.length || next_y >= changed_map[0].length) continue;
                if (changed_map[next_x][next_y] > 0) continue;
                changed_map[next_x][next_y] = 2;
                temp_blink_num--;
                q.offer(new Position(next_x, next_y));
            }
        }
        ans = Math.max(ans, temp_blink_num);
    }

    // 벽을 3개 세우는 경우의 수 만들기
    private static void dfs(int depth) {
        if (depth == 3) {
            int[][] changed_map = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) changed_map[i] = map[i].clone();
            spreadVirus(changed_map);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs =  br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        map = new int[n][m];
        virus = new ArrayList<>();
        String[] temp;
        blink_num = 0;

        for(int i = 0 ; i < n ; i++){
            temp = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
            if(temp[j].equals("0")) {
                blink_num++;
                continue;
            }
            if(temp[j].equals("1")){
                map[i][j] = 1;
                continue;
            }
            map[i][j] = 2;
            virus.add(new Position(i,j));
            }
        }

        dfs(0);

        System.out.println(ans);
        br.close();
    }
}