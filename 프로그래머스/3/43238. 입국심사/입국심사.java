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
        long left = 0;
        long right = Long.MAX_VALUE;
        long mid;
        
        while(left <= right) {
            mid = (left + right)/2;
            
            if (checkUnder(mid, n, times)){
                left = mid + 1;
                continue;
            } // 해당 시간에는 모든 사람이 검사받을 수 없다.

            right = mid - 1;
            answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
        }
        return answer;
    }
}