import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer,List<Node>> graph;
    private static Node end;

    static class Node{
        int idx;
        int weight;

        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

        public int getIdx() {
            return this.idx;
        }
        public int getWeight() {
            return this.weight;
        }
    }

    private static void dfs(int before, int now, int temp_sum) {
        if(graph.get(now).size() == 1 && graph.get(now).get(0).getIdx() == before) {
            if(temp_sum > end.getWeight()) end = new Node(now, temp_sum);
            return;
        }

        for(Node next : graph.get(now)){
            if(next.getIdx() == before) continue;
            dfs(now, next.getIdx(), temp_sum + next.getWeight());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        end = new Node(0,0);
        String[] inputs;
        int a;

        for(int i = 1 ; i <= n ; i++){
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            graph.put(a, new ArrayList<>());
            for(int j = 1 ; j < inputs.length-1 ; j+=2) {
                graph.get(a).add(new Node(Integer.parseInt(inputs[j]), Integer.parseInt(inputs[j + 1])));
            }
        }
        // 각 노드에서 대해서 가장 먼거리 탐색
        dfs(1, 1, 0);

        // 가장 긴 노드에서 가장 먼거리 탐색
        int root = end.getIdx();
        Node child = graph.get(root).get(0);
        dfs(root, child.getIdx(), child.getWeight());

        System.out.print(end.getWeight());
        br.close();
    }
}
