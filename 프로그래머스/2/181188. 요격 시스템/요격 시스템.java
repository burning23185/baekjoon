import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        if(targets.length < 1) return 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int answer = 1;
        int end_idx = targets[0][1] - 1;

        for (int i = 1 ; i < targets.length ; i++) {
            if (targets[i][0] <= end_idx && end_idx <= targets[i][1]) continue;
            answer++;
            end_idx = targets[i][1] - 1;
        }
        return answer;
    }
}