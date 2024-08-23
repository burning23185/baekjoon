public class Solution {
    private final int[][] dir = new int[][]{new int[]{0,1},new int[]{1,0},new int[]{0,-1},new int[]{-1,0}};
    public int solution(String[][] board, int h, int w) {
        String target = board[h][w];
        int nx, ny;
        int answer = 0;
        for(int[] adj : dir){
            nx = h+adj[0];
            ny = w+adj[1];
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            answer += board[nx][ny].equals(target) ? 1 : 0;
        }
        return answer;
    }
}