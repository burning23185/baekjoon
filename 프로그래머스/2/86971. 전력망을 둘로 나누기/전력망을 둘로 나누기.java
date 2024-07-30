import java.util.*;

public class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    
    private int dfs(int i){
        if(graph[i].size() <= 1) return 1;

        visited[i] = true;
        int res = 1;
        for(int next : graph[i]){
            if(visited[next]) continue;
            res += dfs(next);
        }
        visited[i] = false;
        return res;
    }

    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<>();

        for(int[] adj : wires){
            graph[adj[0]].add(adj[1]);
            graph[adj[1]].add(adj[0]);
        }

        for( int i = 1 ; i <= n ; i++){
            if(graph[i].size() <= 1) continue;
            visited[i] = true;
            for(int adj : graph[i]){
                answer = Math.min(answer, Math.abs(n - 2*dfs(adj)));
            }
            visited[i] = false;
        }
        return answer;
    }
}