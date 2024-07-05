import java.util.Arrays;
class Solution {
    private boolean checkUnder(long mid, int n, int[] times){
        long complete = 0;
        for (int t : times) {
            complete += mid / t;
            if(complete >= n) return false;
        }
        return true;
    }
        
    public long solution(int n, int[] times) {
        long answer = 0;
        long low = 0;
        // N 명의 사람을 모두 통과시킬 수 있는 가장 긴 시간
        long high = Long.MAX_VALUE;
        long mid;
        
        while(low <= high) {
            mid = (low + high)/2;
            
            if (checkUnder(mid, n, times)){
                low = mid + 1;
                continue;
            } // 해당 시간에는 모든 사람이 검사받을 수 없다.

            high = mid - 1;
            answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
        }
        return answer;
    }
}