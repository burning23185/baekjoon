import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        String[] inputs = br.readLine().split(" ");
        for(int i = 1 ; i <= n ; i++) nums[i] = Integer.parseInt(inputs[i-1]);
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + nums[j]);
            }
            dp[i] = Math.max(dp[i], nums[i]);
        }
        System.out.println(dp[n]);
    }
}