import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static int[] in_order_idx;
    private static int[] post_order;

    public static void devideTree(int in_start, int in_end, int post_start, int post_end) {
        if(in_start > in_end || post_start > post_end) return;

        int rootNode = post_order[post_end];
        sb.append(rootNode + " ");

        int root_idx = in_order_idx[rootNode];
        int sub_length = root_idx - in_start;

        //왼쪽
        devideTree(in_start, root_idx-1, post_start, post_start+sub_length-1);
        //오른쪽
        devideTree(root_idx+1, in_end, post_start+sub_length, post_end-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        in_order_idx = new int[n+1];
        post_order = new int[n];

        String[] in_order_str = br.readLine().split(" ");
        String[] post_order_str = br.readLine().split(" ");

        for(int i = 0 ; i < n; i++){
            in_order_idx[Integer.parseInt(in_order_str[i])] = i;
            post_order[i] = Integer.parseInt(post_order_str[i]);
        }

        devideTree(0, n-1, 0, n-1);
        System.out.println(sb);
        br.close();
    }
}
