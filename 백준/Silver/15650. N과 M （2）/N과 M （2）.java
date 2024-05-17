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
        selected = new int[m+1];
        sb = new StringBuilder();
        br.close();
    }

    static void recFunc(int now){
        if(now == m+1){
            for(int j = 1 ; j <= m ; j++) sb.append(selected[j]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i = selected[now - 1] + 1 ; i <= n ; i++){
            selected[now] = i;
            recFunc(now + 1);
            selected[now] = 0;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }  
}