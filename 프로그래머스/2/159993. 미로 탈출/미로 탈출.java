import java.util.*;

class Solution {
    //시작 지점 : 2 , 출구 : 3, 레버 : 4, 벽 : 1, 이동가능 : 0
    private int[][] board;
    private Position[] dir = new Position[]{
            new Position(0,1),new Position(1,0),new Position(0,-1),new Position(-1,0)};
    private int ans = -1;
    
    static class Position{
        private final int x;
        private final int y;
        private final int length;

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

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getLength() {
            return length;
        }
    }


    private void bfs(Position start, int target) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);

        boolean[][] visited = new boolean[board.length][board[0].length];
        Position now;
        while (!queue.isEmpty()) {
            now = queue.poll();
            visited[now.getX()][now.getY()] = true;

            if (board[now.getX()][now.getY()] == target) ans = now.getLength();

            for (Position next : dir) {
                int nx = now.getX() + next.getX();
                int ny = now.getY() + next.getY();

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                if (visited[nx][ny] || board[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.add(new Position(nx, ny, now.getLength() + 1));
            }
        }
    }


    private int markToInt(char mark){
        if(mark == 'O') return 0;
        if(mark == 'X') return 1;
        if(mark == 'S') return 2;
        if(mark == 'L') return 3;
        if(mark== 'E') return 4;
        return 0;
    }
    public int solution(String[] maps) {
        int answer = 0;
        board = new int[maps.length][maps[0].length()];

        Position start = new Position(0, 0);
        Position lever = new Position(0, 0);
        int flag = 0;

        for(int i = 0 ; i < maps.length ; i++){
            for(int j = 0 ; j < maps[0].length() ; j++){
                flag = markToInt(maps[i].charAt(j));
                if(flag == 2) start = new Position(i, j);
                if(flag == 3) lever = new Position(i, j);
                board[i][j] = flag;
            }
        }

        bfs(start,3);
        if(ans == -1) return -1;
        answer += ans;

        ans = -1;
        bfs(lever,4);

        return (ans == -1) ? -1 : ans + answer;
    }
}