import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 길이가 1일때는 자기자신 밖에 없음
        int[][] dp = new int[n + 1][10];
        for (int i = 0; i < 10; i++) dp[1][i] = 1;

        // 길이가 1이상의 결과값 계산
        for (int i = 2; i <= n; i++) {
            // 끝 자리가 j일 때 오르막 수 구하기
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
            }
        }
        int ans = 0;
        for(int i = 0 ; i < 10 ; i++) ans += dp[n][i];
        System.out.println(ans % 10007);
    }
}