import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> waitingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> processingQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for(int[] job : jobs) waitingQueue.offer(job);

        int answer = 0;
        int now= 0;

        while (!waitingQueue.isEmpty() || !processingQueue.isEmpty()) {
            // 현재 시간 이내에 요청된 모든 작업을 처리 큐로 이동
            while (!waitingQueue.isEmpty() && waitingQueue.peek()[0] <= now)
                processingQueue.offer(waitingQueue.poll());
            
            if (!processingQueue.isEmpty()) {
                int[] job = processingQueue.poll();
                now += job[1];
                answer += now - job[0];
                continue;
            }
            // 처리할 작업이 없다면 다음 요청 시간으로 이동
            now = waitingQueue.peek()[0];
        }
        return answer / jobs.length;
    }
}