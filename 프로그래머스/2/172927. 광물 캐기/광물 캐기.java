import java.util.*;

public class Solution {

    public int solution(int[] picks, String[] minerals) {
        List<int[]> vals = new ArrayList<>();
        int temp = 0;
        int cnt = 0;
        for(int i = 0 ; i < minerals.length ; i += 5){
            for(int j = i ; j < i+5 ; j++) {
                if(j == minerals.length) break;
                cnt++;
                if (minerals[j].charAt(0) == 'd') temp += 25;
                else if (minerals[j].charAt(0) == 'i') temp += 5;
                else if (minerals[j].charAt(0) == 's') temp += 1;
            }
            vals.add(new int[]{temp, cnt});
            temp = 0;
            cnt = 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < picks.length ; i++){
            for(int j = 0 ; j < picks[i] ; j++) queue.offer(i);
        }

        int pick;
        int answer = 0;

        if(vals.size() > queue.size()) vals = vals.subList(0, vals.size()-1);
        vals.sort(Comparator.comparingInt(o -> -o[0]));

        for(int[] val : vals){
            pick = queue.poll();
            if(pick == 0) answer += val[1];
            else if(pick == 1) answer += Math.max(val[0]/5 + val[0]%5, val[1]);
            else answer += val[0];
        }
        return answer;
    }
}