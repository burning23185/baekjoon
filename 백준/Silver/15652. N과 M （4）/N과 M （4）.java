import java.io.*;
public class Main {
    private static int n;
    private static int m;
    private static int[] selected;
    private static StringBuilder sb;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        selected = new int[m];
        br.close();
    }

    static void recFunc(int k, int now){
        if(k == m + 1) {
            for (int i : selected) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i = now ; i <= n ; i++){
            selected[k-1] = i;
            recFunc(k+1, i);
        }
    }

	public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        input();
        recFunc(1, 1);
        System.out.println(sb);
	}
}