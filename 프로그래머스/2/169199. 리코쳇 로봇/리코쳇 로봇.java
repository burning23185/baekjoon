import java.util.*;

class Solution {
    
    static class Position{
        private final int x;
        private final int y;
        private final int cnt;
        
        public Position(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int solution(String[] board) {
        
        int[][] map = new int[board.length][board[0].length()];
        Position start = null;
        Position[] dir = new Position[]{
                new Position(0,1),new Position(1,0),new Position(0,-1),new Position(-1,0)};
        Set<Position> visited = new HashSet<>();

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length() ; j++){
                if(board[i].charAt(j) == 'D'){
                    map[i][j] = 1;
                }
                else if(board[i].charAt(j) == 'G'){
                    map[i][j] = 2;
                }
                else if(board[i].charAt(j) == 'R'){
                    start = new Position(i,j);
                    map[i][j] = 3;
                }
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        Position now, next;
        int nx, ny;

        while(!queue.isEmpty()){
            now = queue.poll();

            for(Position d : dir){
                nx = now.x;
                ny = now.y;

                while(map[nx][ny] != 1){
                    nx += d.x;
                    ny += d.y;
                    if(nx < 0 || ny < 0|| nx >= board.length || ny >= board[0].length()) break;
                }

                nx -= d.x;
                ny -= d.y;
                if(nx < 0 || ny < 0|| nx >= board.length || ny >= board[0].length()) continue;

                next = new Position(nx, ny, now.cnt+1);
                if(!visited.add(next)) continue;
                if(map[nx][ny] == 2) return next.cnt;
                queue.offer(next);
            }
        }
        return -1;
    }
}