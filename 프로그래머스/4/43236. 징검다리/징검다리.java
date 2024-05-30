import java.util.*;

class Solution {

    // 돌 사이의 간격이 target 보다 작은 경우 제거
    private int removeRock(int[] rocks, int target){
        int prev = 0;
        int count = 0;

        for(int rock : rocks){
            if(rock - prev < target){
                count++;
                continue;
            }
            prev = rock;
        }
        return count;
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance;
        int mid = 0;
        int[] rock_dist = new int[rocks.length+1]; 
        for(int i = 0 ; i < rocks.length ; i++) rock_dist[i] = rocks[i];
        rock_dist[rocks.length] = distance;

        Arrays.sort(rock_dist);
            
        while(left <= right){
            mid = (left + right)/2;
            int temp = this.removeRock(rock_dist, mid);
            // 제거한 돌 갯수가 n 보다 많은 경우 mid를 오른쪽으로 이동 
            if(temp > n){
                right = mid-1;
                continue;
            }

            answer = mid;
            left = mid+1;
        }
        return answer;
    }
}