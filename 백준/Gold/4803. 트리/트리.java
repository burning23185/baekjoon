import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br;

    // 트리를 형성하면 1 서클을 형성하면 0;
    private static int bfs(Map<Integer,List<Integer>> graph, boolean[] visited, int root) {

        int vertex_cnt = 0;
        int edge_cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        int now;
        while(q.size() > 0){
            now = q.poll();
            if (visited[now]) continue;
            visited[now] = true;
            vertex_cnt++;
            if(!graph.containsKey(root)) return 1;

            //간선수를 count
            for (int next : graph.get(now)) {
                edge_cnt++;
                if (!visited[next]) q.offer(next);
            }
        }
        return (edge_cnt / 2) + 1 == vertex_cnt ? 1 : 0;
    }

    private static String checkTree(Map<Integer,List<Integer>> graph, int n) {
        int ans = 0;
        boolean[] visited = new boolean[n+1];

        //1부터 n까지 순회하면서 트리 갯수 카운트
        for (int i = 1; i <= n; i++) if (!visited[i]) ans += bfs(graph, visited, i);

        return (ans == 0) ? "No trees." :
                ((ans == 1) ? "There is one tree.":
                        String.format("A forest of %d trees.", ans));
    }

    //graph 생성
    private static Map<Integer,List<Integer>> makeGraph(int m) throws IOException {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        String[] inputs;
        for (int i = 1; i <= m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            if(graph.containsKey(a)){
                graph.get(a).add(b);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(b);
                graph.put(a, temp);
            }
            if(graph.containsKey(b)){
                graph.get(b).add(a);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                graph.put(b, temp);
            }
        }
        return graph;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            
            if(n == 0 && m == 0) break;
            sb.append("Case ").append(++cnt).append(": ").append(checkTree(makeGraph(m), n)).append("\n");
        }
        System.out.print(sb);
    }
}