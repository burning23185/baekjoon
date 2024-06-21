import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(input.charAt(0) - '0' == 0){
            System.out.println(0);
            return;
        }

        int[] dp = new int[input.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        int now;
        int before = input.charAt(0) - '0';

        for(int i = 2 ; i <= input.length() ; i++){
            now = input.charAt(i-1) - '0';

            if (now > 0) dp[i] += dp[i - 1];

            int temp = before * 10 + now ;
            before = now;

            if (10 <= temp && temp <= 26) dp[i] += dp[i - 2];
            dp[i] %= 1000000;
        }
        System.out.println(dp[input.length()]);
    }
}