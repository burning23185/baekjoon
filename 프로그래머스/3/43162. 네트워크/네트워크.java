import java.util.*;

class Solution {
    private boolean[] visited;
    List<List<Integer>> networks;
    private void findConnected(List<Integer> connected){
        for(int next : connected){
            if(visited[next]) continue;
            visited[next] = true;
            findConnected(networks.get(next));
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        networks = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) networks.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    networks.get(i).add(j);
                    networks.get(j).add(i);
                }
            }
        }
        //모든 노드에 대해서 순회
        for(int i = 0 ; i < n ; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            findConnected(networks.get(i));
            answer++;
        }
        return answer;
    }
}