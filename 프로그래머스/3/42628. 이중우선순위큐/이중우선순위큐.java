import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    private Integer poll(PriorityQueue<Integer> q, Map<Integer, Integer> stock){
        while(!q.isEmpty() && stock.get(q.peek()) == 0) q.poll();
        if(q.isEmpty()) return null;
        stock.put(q.peek(), stock.get(q.peek())-1);
        return q.poll();
    }

    public int[] solution(String[] operations) {
        Map<Integer,Integer> stock= new HashMap<>();
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        PriorityQueue<Integer> max_q = new PriorityQueue<>(Comparator.reverseOrder());
        String[] temp;

        int num;
        for(String op : operations){
            temp = op.split(" ");
            if(temp[0].equals("I")){
                num = Integer.parseInt(temp[1]);
                min_q.offer(num);
                max_q.offer(num);
                stock.put(num, stock.getOrDefault(num, 0)+1);
                continue;
            }
            poll((Integer.parseInt(temp[1]) < 0 ? min_q : max_q), stock);
        }
        Integer min = poll(min_q, stock);
        if(min == null) return new int[]{0,0};

        Integer max = poll(max_q, stock);
        if(max == null) return new int[]{min, min};
        
        return new int[]{max, min};
    }
}