import java.util.*;

public class Solution {
    private char[][] map;
    private Position[] dir = new Position[]{
            new Position(0,1), new Position(1,0), new Position(0,-1), new Position(-1,0)};

    private static class Position{
        int x;
        int y;
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

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    private boolean bfs(Queue<Position> queue){
        int nx, ny, nx2, ny2;
        Position now;
        while(!queue.isEmpty()) {
            now = queue.poll();

            for (Position next : dir) {
                nx = now.getX() + next.getX();
                ny = now.getY() + next.getY();
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (map[nx][ny] == 'X') continue;
                if (map[nx][ny] == 'P') return true;

                for (Position nextNext : dir) {
                    nx2 = nx + nextNext.getX();
                    ny2 = ny + nextNext.getY();
                    if (nx2 < 0 || ny2 < 0 || nx2 >= map.length || ny2 >= map[0].length) continue;
                    if (nx2 == now.getX() && ny2 == now.getY()) continue;
                    if (map[nx2][ny2] == 'P') return true;
                }
            }
        }
        return false;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Queue<Position> queue = new LinkedList<>();

        for(int t = 0 ; t < places.length ; t++){
            map = new char[places[t].length][places[t][0].length()];

            for(int i = 0 ; i < map.length ; i++){
                for(int j = 0 ; j < map[0].length ; j++){
                    map[i][j] = places[t][i].charAt(j);
                    if(places[t][i].charAt(j) == 'P') queue.offer(new Position(i,j));
                }
            }
            answer[t] = bfs(queue) ? 0 : 1;
            queue.clear();
        }
        return answer;
    }
}