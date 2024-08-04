import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final List<List<Integer>> graph;
    private final boolean[] visited;
    int vertex;
    int edge;

    public Main(int vertex, int edge){
        this.vertex = vertex;
        this.edge = edge;
        this.graph = new ArrayList<>();
        this.visited = new boolean[vertex+1];
        init();
    }

    private void init(){
        for(int i = 0 ; i <= vertex ; i++) graph.add(new ArrayList<>());
    }

    private void input(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    private int run(){
        int ans = 0;
        for(int i = 1; i <= vertex ; i++){
            if(visited[i]) continue;
            bfs(i);
            ans++;
        }
        return ans;
    }

    private void bfs(int start){
       Queue<Integer> queue = new LinkedList<>();
       queue.offer(start);
       visited[start] = true;
       int now;
       while(!queue.isEmpty()){
           now = queue.poll();
           for(int next : graph.get(now)){
               if(visited[next]) continue;
               visited[next] = true;
               queue.offer(next);
           }
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] conf = br.readLine().split(" ");
        int vertex = Integer.parseInt(conf[0]);
        int edge = Integer.parseInt(conf[1]);

        Main m = new Main(vertex, edge);

        for(int i = 0 ; i < edge ; i++){
            String[] edge_info = br.readLine().split(" ");
            m.input(Integer.parseInt(edge_info[0]), Integer.parseInt(edge_info[1]));
        }
        System.out.println(m.run());
    }
}
