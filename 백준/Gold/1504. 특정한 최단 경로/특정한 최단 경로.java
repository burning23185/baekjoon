import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<int[]>> graph;
    private static int[] weights;
    private static boolean[] visited;

    private static int dijkstra(int start, int end){
        visited = new boolean[graph.size()+1];
        weights = new int[graph.size() + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        weights[start] = 0;
        int[] now;

        while(!pq.isEmpty()){
            now = pq.poll();

            if(visited[now[0]]) continue;
            visited[now[0]] = true;

            for(int[] next : graph.get(now[0])){
                if(weights[next[0]] <= now[1] + next[1]) continue;
                weights[next[0]] = now[1] + next[1];
                pq.offer(new int[]{next[0], weights[next[0]]});
            }
        }
        return weights[end];
    }

    private static int doDij(int a, int b, int n){
        int res = 0;

        int temp = dijkstra(1, a);
        if(temp == Integer.MAX_VALUE) return -1;
        res += temp;

        temp = dijkstra(a, b);
        if(temp == Integer.MAX_VALUE) return -1;
        res += temp;

        temp = dijkstra(b, n);
        if(temp == Integer.MAX_VALUE) return -1;
        res += temp;

        return res;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int t = Integer.parseInt(in[1]);

        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());

        int s,e,w;

        for(int i = 0 ; i < t ; i++) {
            in = br.readLine().split(" ");
            s = Integer.parseInt(in[0]);
            e = Integer.parseInt(in[1]);
            w = Integer.parseInt(in[2]);
            graph.get(s).add(new int[]{e, w});
            graph.get(e).add(new int[]{s, w});
        }
        in = br.readLine().split(" ");
        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);

        System.out.println(Math.min(doDij(a, b, n), doDij(b, a, n)));
        br.close();
    }
}