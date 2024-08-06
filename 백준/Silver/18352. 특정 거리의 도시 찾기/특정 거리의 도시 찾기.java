import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());
        boolean[] visited = new boolean[n+1];
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);
        int x = Integer.parseInt(strs[3]);

        String[] adj;
        for(int i = 0 ; i < m ; i++){
            adj = br.readLine().split(" ");
            graph.get(Integer.parseInt(adj[0])).add(Integer.parseInt(adj[1]));
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0});
        visited[x] = true;
        int[] now;
        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            now = q.poll();

            for(int next : graph.get(now[0])){
                if(visited[next]) continue;
                visited[next] = true;
                if(now[1]+1 == k) {
                    res.add(next);
                    continue;
                }
                q.offer(new int[]{next, now[1]+1});
            }
        }
        if(res.isEmpty()) {
            System.out.println(-1);
            return;
        }

        res.sort(Comparator.naturalOrder());
        for(int num : res) sb.append(num).append("\n");

        System.out.println(sb);
    }
}
