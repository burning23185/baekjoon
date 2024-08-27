import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static class Node {
        private Node parent;
        private int val;
        private int rank;

        public Node(int val) {
            this.parent = this;
            this.val = val;
            this.rank = 0;
        }
    }

    private static Node[] nodes;

    // Find 연산: 경로 압축을 사용
    private static Node find(Node node) {
        if (node.parent == node) return node;

        node.parent = find(node.parent);
        return node.parent;
    }

    // Union 연산: Union-by-rank 사용
    public static void union(int a, int b) {
        Node root_a = find(nodes[a]);
        Node root_b = find(nodes[b]);
        if(root_a == root_b) return;

        if (root_a.rank < root_b.rank) {
            root_a.parent = root_b;
        } else if (root_a.rank > root_b.rank) {
            root_b.parent = root_a;
        } else {
            root_b.parent = root_a;
            root_a.rank++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) nodes[i] = new Node(i);

        for (int i = 1; i <= n; i++) {
            in = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(in[j-1]) == 0) continue;
                union(i, j);
            }
        }

        in = br.readLine().split(" ");
        Node start = find(nodes[Integer.parseInt(in[0])]);
        boolean isConnected = true;

        for (int i = 1; i < m; i++) {
            if (start != find(nodes[Integer.parseInt(in[i])])) {
                isConnected = false;
                break;
            }
        }
        System.out.println(isConnected ? "YES" : "NO");
        br.close();
    }
}
