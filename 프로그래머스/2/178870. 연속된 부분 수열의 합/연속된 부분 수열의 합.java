class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        int left = 0;
        int right = 0;
        int sum = sequence[left];

        for(int i = 0 ; i < sequence.length ; i++){
            while(sum < k && right + 1 < sequence.length) sum += sequence[++right];
            //sum이 k이상인 경우에만 통과
            if(sum == k && (answer[1] - answer[0]) > right - i){
                answer[0] = i;
                answer[1] = right;
            }
            //left가 1칸 이동하므로 sum에서 감소
            sum -= sequence[i];
        }
        return answer;
    }
}