class Solution {
    private int[] dou_nums;
    private boolean[] visited;
    private int ans;

    private void dfs(int now, int temp, int target){
        if(temp == target) ans++;

        for(int i = now ; i < dou_nums.length ; i++){
            if(visited[i]) continue;
            if(temp <= dou_nums[i]) continue;

            visited[i] = true;
            dfs(i + 1, temp - dou_nums[i], target);
            visited[i] = false;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int sum = 0;
        dou_nums = new int[numbers.length];
        visited = new boolean[numbers.length];

        for(int i = 0 ; i < numbers.length ; i++) {
            sum += numbers[i];
            dou_nums[i] = 2 * numbers[i];
        }
        dfs(0, sum, target);
        return ans;
    }
}