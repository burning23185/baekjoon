import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(dp[1]);
            return;
        }

        int before = Integer.parseInt(br.readLine());
        dp[2] = dp[1] + before;

        int now;
        for(int i = 3 ; i <= n ; i++){
            now = Integer.parseInt(br.readLine());
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + before + now, dp[i-2] + now));
            before = now;
        }
        System.out.println(dp[n]);
    }
}