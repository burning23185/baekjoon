import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        if(targets.length < 1) return 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        int answer = 0;
        int before = 0;

        for(int i=0; i<targets.length; i++){
            if(before <= targets[i][0]){
                before = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}