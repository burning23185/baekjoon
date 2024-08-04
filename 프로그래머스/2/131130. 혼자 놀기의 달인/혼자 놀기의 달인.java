import java.util.*;

class Solution {
    private boolean[] visited;
    
    private int openBox(int[] cards, int start){
        int cnt = 0;
        int now = start;
        
        while(!visited[now+1]){
            cnt++;
            visited[now+1] = true;
            now = cards[now] - 1;
        }
        return cnt;
    }
    
    public int solution(int[] cards) {
        visited = new boolean[cards.length+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < cards.length ; i++){
            if(visited[i+1]) continue;
            pq.add(openBox(cards, i));
        }
        return  (pq.size() == 1) ? 0 : pq.poll() * pq.poll();
    }
}