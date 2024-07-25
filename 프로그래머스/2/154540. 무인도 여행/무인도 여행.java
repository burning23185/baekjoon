import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    private int[][] board;
    private Position[] dir = {new Position(0,1),new Position(1,0),new Position(-1,0),new Position(0,-1)};

    static class Position{
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

    private int dfs(int x, int y, int now){
        board[x][y] = -1;
        int nx, ny;
        int res = now;

        for(Position next : dir){
            nx = x + next.getX();
            ny = y + next.getY();
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            if(board[nx][ny] == -1) continue;
            res += dfs(nx, ny, board[nx][ny]);
        }
        return res;
    }

    public int[] solution(String[] maps) {
        this.board= new int[maps.length][maps[0].length()];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < maps.length ; i++){
            for(int j = 0 ; j < maps[0].length() ; j++){
                this.board[i][j] = (maps[i].charAt(j) == 'X') ? -1 : maps[i].charAt(j) - '0';
            }
        }

        for(int i = 0 ; i < this.board.length ; i++){
            for(int j = 0 ; j < this.board[0].length ; j++){
                if(this.board[i][j] == -1) continue;
                ans.add(dfs(i,j,this.board[i][j]));
            }
        }
        ans.sort(Comparator.comparingInt(o -> o));

        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++) answer[i] = ans.get(i);

        return answer.length > 0 ? answer : new int[]{-1};
    }
}