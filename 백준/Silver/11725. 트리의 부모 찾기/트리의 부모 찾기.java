import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>[] adj;
    private static int[] parents;

    static void dfs(int now){
        for(int n : adj[now]){
            if(parents[now] == n) continue;
            parents[n] = now;
            dfs(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] inputs;
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        parents = new int[n+1];
        int a, b;

        for(int i = 1 ; i < n ; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1);
        for(int i = 2; i <= n ; i++) sb.append(String.format("%d%n", parents[i]));
        System.out.println(sb);
        br.close();
    }
}