import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n == 1){
            System.out.println(1);
            return;
        }
        
        long[] dp = new long[n+1];
        dp[1] = 1L;
        dp[2] = 1L;

        for(int i = 3 ; i <= n ; i++) dp[i] = dp[i-1] + dp[i-2];
        System.out.println(dp[n]);
    }
}