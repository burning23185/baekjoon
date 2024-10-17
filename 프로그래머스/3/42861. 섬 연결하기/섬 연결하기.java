import java.util.Arrays;

class Solution {
    private int findParent(int[] parents, int now) {
        return parents[now] == now ? now : findParent(parents, parents[now]);
    }
    private void union(int[] parents, int node1, int node2) {
        int p1 = findParent(parents, node1);
        int p2 = findParent(parents, node2);

        if (p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) parents[i] = i;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int[] cost : costs) {
            // 사이클 판단
            if (findParent(parents, cost[0]) != findParent(parents, cost[1])) {
                answer += cost[2];
                union(parents, cost[0], cost[1]);
            }
        }

        return answer;
    }
}