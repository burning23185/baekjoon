import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int next : graph.get(now[0])){
                if(visited[next]) continue;
                visited[next] = true;
                res.get(now[1]+1).add(next);
                q.offer(new int[]{next, now[1]+1});
            }
        }
        //최대 거리 출력
        for(int i = n ; i >= 1 ; i--){
            if(!res.get(i).isEmpty()) return res.get(i).size();
        }
        return 0;
    }
}