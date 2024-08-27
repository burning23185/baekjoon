import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] parents;

    public static int findParent(int x) {
        if(x == parents[x]) return parents[x];

        parents[x] = findParent(parents[x]);
        return parents[x];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        parents = new int[n+1];
        for(int i = 0 ; i <= n ; i++) parents[i] = i;

        int a, b;
        for(int i = 0 ; i < m ; i++){
            in = br.readLine().split(" ");
            a = Integer.parseInt(in[1]);
            b = Integer.parseInt(in[2]);

            if(in[0].equals("1")){
                sb.append((findParent(a) != findParent(b)) ? "NO" : "YES").append("\n");
                continue;
            }
            parents[findParent(b)] = findParent(a);
        }
        System.out.println(sb);
        br.close();
    }
}