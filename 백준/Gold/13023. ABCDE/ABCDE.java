import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final int n;
    private final List<List<Integer>> graph;
    private boolean[] visited;

    public Main(int n){
        this.n = n;
        graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
    }

    public void input(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    private boolean dfs(int now, int depth){
        if(depth == 5) return true;
        for(int next : graph.get(now)){
            if(visited[next]) continue;
            visited[next] = true;
            if(dfs(next, depth+1)) return true;
            visited[next] = false;
        }
        return false;
    }

    private int run(){
        for(int i = 0 ; i < n ; i++){
            visited = new boolean[n];
            visited[i] = true;
            if(dfs(i,1)) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conf = br.readLine().split(" ");
        int t = Integer.parseInt(conf[1]);

        Main m = new Main(Integer.parseInt(conf[0]));
        for(int i = 0 ; i < t ; i++){
            String[] adj = br.readLine().split(" ");
            m.input(Integer.parseInt(adj[0]), Integer.parseInt(adj[1]));
        }
        System.out.println(m.run());
    }
}