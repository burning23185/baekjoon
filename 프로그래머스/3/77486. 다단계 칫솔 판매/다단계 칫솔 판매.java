import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> score = new HashMap<>();
        for(String n : enroll){ score.put(n, 0); }
        score.put("-", 0);
        Map<String, String> graph = new HashMap<>();

        for(int i = 0 ; i < referral.length ; i++){
            graph.put(enroll[i], referral[i]);
        }
        String target;
        for(int i = 0 ; i < seller.length ; i++){
            target = seller[i];
            int value = amount[i] * 100;
            int fee = (int) (value * 0.1);
            score.put(target, score.get(target) + value - fee);

            while(graph.containsKey(target)){
                target = graph.get(target);
                value = fee;
                fee = (int) (value * 0.1);
                score.put(target, score.get(target) + value - fee);
                if(fee == 0) break;
            }
        }
        int[] answer = new int[enroll.length];
        for(int i = 0 ; i < enroll.length ; i++){
            answer[i] = score.get(enroll[i]);
        }
        return answer;
    }
}