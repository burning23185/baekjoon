import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, List<Integer>> adj;
    private static int[] parents;

    static void dfs(int now){
        for(int n : adj.get(now)){
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
        adj = new HashMap<>();
        parents = new int[n+1];
        int a, b;

        for(int i = 1 ; i < n ; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);

            if(adj.containsKey(a)){
                adj.get(a).add(b);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(b);
                adj.put(a, temp);
            }

            if(adj.containsKey(b)){
                adj.get(b).add(a);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                adj.put(b, temp);
            }
        }

        dfs(1);
        for(int i = 2; i <= n ; i++) sb.append(String.format("%d%n", parents[i]));
        System.out.println(sb);
        br.close();
    }
}