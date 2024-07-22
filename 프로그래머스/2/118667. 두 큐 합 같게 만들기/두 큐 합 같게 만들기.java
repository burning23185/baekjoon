import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;

        int now;
        int size = 3 * queue1.length;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while(count < size) {
            if(sum1 == sum2) return count;
            count++;
            
            if(sum1 > sum2) {
                if (q1.isEmpty()) return -1;
                now = q1.poll();
                q2.add(now);
                sum1 -= now;
                sum2 += now;
                continue;
            }
            if (q2.isEmpty()) return -1;
            now = q2.poll();
            q1.add(now);
            sum1 += now;
            sum2 -= now;
        }
        return -1;
    }
}