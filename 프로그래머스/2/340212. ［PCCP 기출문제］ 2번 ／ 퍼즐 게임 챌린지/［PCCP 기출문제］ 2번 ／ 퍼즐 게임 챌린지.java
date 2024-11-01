class Solution {
    
    private boolean checkAvailable(int[] diffs, int[] times, long limit, int mid){
        long time = 0L;
        for(int i = 0 ; i < diffs.length ; i++){
            if(diffs[i] <= mid) time += times[i];
            else if(i == 0) time += times[i] * (diffs[i] - mid);
            else time += (times[i] + times[i-1]) * (diffs[i] - mid) + times[i];
            if(time > limit) return false;
        }
        return true;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int start = 1;
        int end = 100000;
        int mid;
        
        while(start<=end){
            mid = (start+end)/2;
            if(checkAvailable(diffs, times, limit, mid)){
                answer = (int) Math.min(answer, mid);
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        return answer;
    }
}