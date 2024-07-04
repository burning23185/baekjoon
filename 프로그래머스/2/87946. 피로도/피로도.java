class Solution {
    private int[][] dungeons;
    private boolean[] visited;
    private int ans;

    private void dfs(int stamina, int now, int count){
        for(int i = 0 ; i < dungeons.length ; i++){
            if(visited[i]) continue;
            if(stamina < dungeons[i][0]) continue;
            visited[i] = true;

            dfs(stamina - dungeons[i][1], now+1, count+1);
            visited[i] = false;
        }
        ans = Math.max(ans, count);
    }
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        ans = 0;
        visited = new boolean[dungeons.length+1];

        dfs(k, 0, 0);
        return ans;
    }
}