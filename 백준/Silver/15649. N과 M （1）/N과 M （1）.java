import java.io.*;
public class Main {
    private static int n;
    private static int m;
    private static int[] selected;
    private static boolean[] visited;
    private static StringBuilder sb;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        selected = new int[m];
        visited = new boolean[n + 1];
        br.close();
    }

    static void recFunc(int k){
        if(k == m + 1) {
            for (int i : selected) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = 1 ; i <= n ; i++){
            
            if(visited[i]) continue;
            
            selected[k-1] = i;
            
            visited[i] = true;

            recFunc(k+1);
            
            visited[i] = false;
        }
    }

	public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        input();
        recFunc(1);
        System.out.println(sb);
	}
}