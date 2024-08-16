import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<int[]>> graph;

    private static Map<Integer, Integer> dijkstra(int start){
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        visited.put(start, 0);
        int[] now;

        while (!pq.isEmpty()){
           now = pq.poll();
           for(int[] next : graph.get(now[0])){
               if(visited.containsKey(next[0]) && visited.get(next[0]) <= (now[1] + next[1])) continue;
               visited.put(next[0], now[1] + next[1]);
               pq.offer(new int[]{next[0], visited.get(next[0])});
           }
        }
        return visited;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++){
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int d = Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);
            graph = new ArrayList<>();
            for(int j = 0 ; j <= n ; j++) graph.add(new ArrayList<>());
            for(int j = 0 ; j < d ; j++){
                String[] in2 = br.readLine().split(" ");
                graph.get(Integer.parseInt(in2[1])).add(new int[]{Integer.parseInt(in2[0]), Integer.parseInt(in2[2])});
            }
            Map<Integer,Integer> res = dijkstra(c);
            sb.append(res.size()).append(" ").append(Collections.max(res.values())).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}