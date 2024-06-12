import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Position{
        private int x;
        private int y;
        private int length;

        public Position(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }

        public Position(int x, int y){
            this.x = x;
            this.y = y;
            this.length = 0;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        public int getLength(){ return this.length;}
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs =  br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        boolean[][] map = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        String temp;

        for(int i = 0 ; i < n ; i++){
            temp = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = temp.charAt(j) == '1';
            }
        }

        Position[] direction = new Position[]{
                new Position(0,1), new Position(1,0), new Position(0,-1), new Position(-1,0)};

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,1));
        Position now;
        int next_x, next_y;
        int ans = 0;

        while (q.size() > 0){
            now = q.poll();

            if(now.getX() == n-1 && now.getY() == m-1) {
                ans = now.getLength();
                break;
            }

            for(Position p : direction){
                next_x = now.getX() + p.getX();
                next_y = now.getY() + p.getY();

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= m) continue;
                if(!map[next_x][next_y] || visited[next_x][next_y]) continue;

                visited[next_x][next_y] = true;
                q.add(new Position(next_x, next_y, now.length + 1));
            }
        }

        System.out.println(ans);
        br.close();
    }
}