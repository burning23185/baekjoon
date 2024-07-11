import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;
        int[] natural = new int[size+1];
        int[] reverse = new int[size+1];
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        int rev_idx;
        for(int i = 1 ; i < size ; i++){
            left.add(topping[i-1]);
            natural[i] = left.size();

            rev_idx = size-i;
            right.add(topping[rev_idx]);
            reverse[rev_idx] = right.size();
        }
        natural[size] = left.size();
        reverse[0] = right.size();
        
        for(int i = 1 ; i < size ; i++){
            if(natural[i] == reverse[i]) answer++;
        }
            return answer;
    }
}