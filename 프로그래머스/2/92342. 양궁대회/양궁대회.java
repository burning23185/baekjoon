public class Solution {
    private int[] temp;
    private int[] answer;
    private int max_diff;

    public void checkScore(int[] info) {
        int apeach=0;
        int lion=0;

        for(int i = 0; i< temp.length; i++) {
            if(info[i] < temp[i]) lion += 10-i;
            if(info[i]!=0 && info[i]>= temp[i]) apeach += 10-i;
        }

        int diff = lion - apeach;
        if(max_diff <= diff){
            max_diff = diff;
            answer = temp.clone();
        }
    }

    public void dfs(int depth, int n, int[] info) {
        if(depth==n) {
            checkScore(info);
            return;
        }
        for(int i=0; i < info.length ; i++) {
            //만약 현재 스코어의 화살 수가 이미 어피치보다 많다면 탐색 중단
            if(temp[i] > info[i]) break;
            temp[i] += 1;
            dfs(depth+1, n, info);
            temp[i] -= 1;
        }
    }

    public int[] solution(int n, int[] info) {
        temp = new int[info.length];
        max_diff = 0;
        dfs(0, n, info);
        return max_diff == 0 ? new int[]{-1} : answer;
    }
}