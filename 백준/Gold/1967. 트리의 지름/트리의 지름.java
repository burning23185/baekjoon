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

        if(n == 1){
            System.out.println(0);
            return;
        }
        graph = new HashMap<>();
        end = new Node(0,0);
        String[] inputs;
        int a, b, w;

        for(int i = 1 ; i < n ; i++){
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            w = Integer.parseInt(inputs[2]);
            if(graph.containsKey(a)){
                graph.get(a).add(new Node(b, w));
            }else{
                List<Node> temp = new ArrayList<>();
                temp.add(new Node(b, w));
                graph.put(a, temp);
            }
            if(graph.containsKey(b)){
                graph.get(b).add(new Node(a, w));
            }else{
                List<Node> temp = new ArrayList<>();
                temp.add(new Node(a, w));
                graph.put(b, temp);
            }
        }
        //1을 root로 가장 긴 노드 탐색
        dfs(1,1,0);

        // 가장 긴 노드에서 가장 먼거리 탐색
        int root = end.getIdx();
        Node child = graph.get(root).get(0);
        dfs(root, child.getIdx(), child.getWeight());

        System.out.print(end.getWeight());
        br.close();
    }
}
