import java.util.*;

public class Solution {
    char[][] board;
    int[][] dp;
    Set<Arrow> visited;

    private static class Position{
        private int x;
        private int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
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
    private static class Arrow {
        Position start;
        Position end;
        int dir;

        public Arrow(Position start, Position end, int dir){
            this.start = start;
            this.end = end;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Arrow arrow = (Arrow) o;
            return Objects.equals(start, arrow.start) && Objects.equals(end, arrow.end);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

    }

    private int bfs(Arrow before){
        if(visited.contains(before)) return 0 ;
        Queue<Arrow> queue = new LinkedList<>();
        queue.offer(before);

        Arrow now, next;
        int cnt = 0;
        while(!queue.isEmpty()){
            now = queue.poll();

            int nx = now.end.x;
            int ny = now.end.y;
            int nd = now.dir;

            if(nx < 0){
                queue.offer(new Arrow(now.end, new Position(board.length-1, ny), nd));
                continue;
            }
            if(ny < 0){
                queue.offer(new Arrow(now.end, new Position(nx, board[0].length-1), nd));
                continue;
            }
            if(nx >= board.length){
                queue.offer(new Arrow(now.end, new Position(0, ny), nd));
                continue;
            }
            if(ny >= board[0].length){
                queue.offer(new Arrow(now.end, new Position(nx, 0), nd));
                continue;
            }

            nd = rotate(now.end.x, now.end.y, nd);

            if (nd == 0) ny++;
            else if (nd == 1) nx++;
            else if (nd == 2) ny--;
            else nx--;

            next = new Arrow(now.end, new Position(nx, ny), nd);

            if(visited.add(next)) {
                queue.offer(next);
                cnt++;
            }
        }
        return cnt;
    }

    private int rotate(int x, int y, int dir){
        if(board[x][y] == 'L') return (dir == 0) ? 3 : dir - 1;
        if(board[x][y] == 'R') return (dir == 3) ? 0 : dir + 1;
        return dir;
    }

    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        board = new char[grid.length][grid[0].length()];
        visited = new HashSet<>();

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length() ; j++){
                board[i][j] = grid[i].charAt(j);
            }
        }

        int temp, x, y;

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    if(k%2 == 0){
                        x = i;
                        y = (k==0) ? -1 : +1;
                    }else{
                        x = (k==1) ? -1 : 1;
                        y = j;
                    }
                    temp = bfs(new Arrow(new Position(x,y), new Position(i,j),k));
                    if(temp > 0) answer.add(temp);
                }
            }
        }

        int[] res = new int[answer.size()];
        answer.sort(Comparator.naturalOrder());

        for(int i = 0 ; i < res.length ; i++) res[i] = answer.get(i);
        return res;
    }
}