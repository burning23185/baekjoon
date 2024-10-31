import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long[] dp = new long[2];
        long flag = 1L;
        
        for(int seq : sequence){
            dp[0] = Math.max(0, dp[0] + flag*seq);
            dp[1] = Math.max(0, dp[1] + (-1*flag*seq));
            answer = Math.max(answer, Math.max(dp[0], dp[1]));
            flag *= -1;
        }
        
        return answer;
    }
}