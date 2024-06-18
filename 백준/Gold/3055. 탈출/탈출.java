import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static boolean[][] waters;
    private static boolean[][] visited;
    private static Position finish;
    private static int ans = -1;

    private static Position[] directions = {
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
        public int getY(){
            return this.y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    private static class Hedgehog{
        private Position position;
        private int move_time;
        public Hedgehog(Position position, int move_time){
            this.position = position;
            this.move_time = move_time;
        }
        public Position getPosition(){
            return this.position;
        }
        public int getMoveTime() {
            return this.move_time;
        }

        @Override
        public String toString() {
            return "Hedgehog{" +
                    "position=" + position +
                    ", move_time=" + move_time +
                    '}';
        }
    }

    private static Queue<Position> spreadWater(Queue<Position> before, int r, int c){
        int nx, ny;
        Position now;
        Queue<Position> after = new LinkedList<>();

        while (!before.isEmpty()){
            now = before.poll();

            for(Position dir : directions){
                nx = now.getX() + dir.getX();
                ny = now.getY() + dir.getY();

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(waters[nx][ny]) continue;

                Position next = new Position(nx, ny);
                if(finish.equals(next)) continue;
                waters[nx][ny] = true;
                after.offer(next);
            }
        }
        return after;
    }
    private static Queue<Hedgehog> moveHegehog(Queue<Hedgehog> before, int r, int c){
        int nx, ny;
        Hedgehog now;
        Queue<Hedgehog> after = new LinkedList<>();

        while (!before.isEmpty()){
            now = before.poll();
            if(now.getPosition().equals(finish)){
                ans = now.getMoveTime();
                return after;
            }
            for(Position dir : directions){
                nx = now.getPosition().getX() + dir.getX();
                ny = now.getPosition().getY() + dir.getY();

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(waters[nx][ny] || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                after.offer(new Hedgehog(new Position(nx, ny), now.getMoveTime() + 1));
            }
        }
        return after;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input_one = br.readLine().split(" ");
        int r = Integer.parseInt(input_one[0]);
        int c = Integer.parseInt(input_one[1]);
        char[][] map = new char[r][c];
        waters = new boolean[r][c];
        visited = new boolean[r][c];

        String input_two;
        char temp;
        Queue<Hedgehog> q = new LinkedList<>();
        Queue<Position> before_water = new LinkedList<>();

        for(int i = 0 ; i < r ; i++) {
            input_two = br.readLine();
            for(int j = 0 ; j < c ; j++){
                temp = input_two.charAt(j);
                map[i][j] = temp;

                if(temp == 'S'){
                    q.offer(new Hedgehog(new Position(i, j), 0));
                    visited[i][j] = true;

                }
                else if(temp == 'D'){
                    finish = new Position(i, j);
                }
                else if(temp == '*') {
                    waters[i][j] = true;
                    before_water.offer(new Position(i, j));
                }else if(temp == 'X'){
                    waters[i][j] = true;
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            // 물 먼저 퍼뜨리기
            before_water = spreadWater(before_water, r, c);
            //고슴도치 이동
            q = moveHegehog(q, r, c);
        }
        System.out.println(ans < 0 ? "KAKTUS" : ans);
    }
}