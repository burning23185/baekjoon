class Solution {
    public int[] solution(int n) {
        if (n == 1) return new int[]{1};
        if (n == 2) return new int[]{1, 2, 3};

        int size = 0;
        for(int i = 1 ; i <= n ; i++) size += i;
        
        int[] answer = new int[size];
        int cnt = n;
        int flag = 0;
        int idx_step = 0;
        int num = 1;

        while(cnt > 0){
            //아래로
            for(int i = 0 ; i < cnt ; i++) {
                flag += idx_step++;
                answer[flag] = num++;
            }

            //오른쪽으로
            flag++;
            cnt--;
            for(int i = 0 ; i < cnt ; i++) answer[flag++] = num++;

            //위로
            flag--;
            cnt--;
            for(int i = 0 ; i < cnt ; i++) {
                flag -= idx_step--;
                answer[flag] = num++;
            }
            cnt--;
        }
        return answer;
    }
}