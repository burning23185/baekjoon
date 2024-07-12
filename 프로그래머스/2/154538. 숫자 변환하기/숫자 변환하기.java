class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        int temp;
        int[] nums = new int[]{2, 3, n};

        if(2*x <= y) dp[2*x] = dp[x] + 1;
        if(3*x <= y) dp[3*x] = dp[x] + 1;
        if(n+x <= y) dp[n+x] = dp[x] + 1;

        for (int i = x+1 ; i <= y ; i++) {
            if (dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            for(int j = 0 ; j < nums.length ; j++){
                temp = (j == nums.length-1) ? nums[j] + i : nums[j] * i;
                if (temp > y) continue;
                dp[temp] = (dp[temp] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[temp]);
            }
        }
    return dp[y];
    }
}