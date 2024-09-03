import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {

        List<Integer> res = new ArrayList<>();
        res.add(k);
        while(k > 1){
            if(k%2 == 0) k = k/2;
            else k = 3*k + 1;
            res.add(k);
        }

        double[] answer = new double[ranges.length];
        double[] temp_sum = new double[res.size()];
        int a,b;
        temp_sum[0] = 0;

        for(int i = 1 ; i < res.size() ; i++){
            if(res.get(i-1) < res.get(i)){
                a = i;
                b = i-1;
            }else{
                a = i-1;
                b = i;
            }
            temp_sum[i] = temp_sum[i-1] + (double) (res.get(a) - res.get(b))/2 + res.get(b);
        }

        double before, after;
        for(int i = 0 ; i < ranges.length ; i++){
            if(temp_sum.length + ranges[i][1] < 1 || ranges[i][0] >= temp_sum.length ){
                answer[i] = -1;
                continue;
            }
            before = temp_sum[ranges[i][0]];
            after = temp_sum[temp_sum.length + ranges[i][1] - 1];

            answer[i] = after - before;
            answer[i] = answer[i] < 0 ? -1 : answer[i];
        }
        return answer;
    }
}