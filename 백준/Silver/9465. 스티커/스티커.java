import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i=0 ; i < t ; i++) {
            int n = Integer.parseInt(br.readLine());

            int [][] map = new int[2][n];
            long [][] dp = new long[2][n];
            long max = 0;

            for(int j = 0 ; j < 2 ; j++){
                String[] temp = br.readLine().split(" ");
                for (int k = 0; k < n; k++) map[j][k] = Integer.parseInt(temp[k]);
            }

            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];
            max = Math.max(max, Math.max(dp[0][0], dp[1][0]));

            if(n == 1) {
                sb.append(String.format("%d %n", max));
                continue;
            }

            dp[0][1] = dp[1][0] + map[0][1];
            dp[1][1] = dp[0][0] + map[1][1];
            max = Math.max(max, Math.max(dp[0][1], dp[1][1]));

            for(int j = 2 ; j < n ; j++){
                dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + map[0][j];
                dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + map[1][j];
                max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
            }
            sb.append(String.format("%d %n", max));
        }
        System.out.println(sb);
        br.close();
    }
}