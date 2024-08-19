class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] temp = new int[n+1];
        
        for(int k : reserve) temp[k]++;
        for(int m : lost) temp[m]--;
        
        for(int i = 1 ; i <= n ; i++){
            if(temp[i] >= 0){
                answer++;
                continue;
            }
            //옷을 도난 당한 경우
            //앞 번호 사람 옷 빌리는 경우
            if(temp[i-1] > 0){
                temp[i-1]--;
                answer++;
            //뒷 번호 사람 옷 빌리는 경우
            }else if(i != n && temp[i+1] > 0){
                temp[i+1]--;
                answer++;
            }
        }
        return answer;
    }
}