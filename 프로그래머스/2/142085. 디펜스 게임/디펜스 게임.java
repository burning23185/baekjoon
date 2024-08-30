import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    private boolean checkFunc(int n, int k, int target, int[] enemy){
        int res = n;
        List<Integer> enemies = new ArrayList<>();
        for(int i = 0 ; i < target ; i++) enemies.add(enemy[i]);
        enemies.sort(Comparator.reverseOrder());

        for(int i = k ; i < enemies.size() ; i++){
            res -= enemies.get(i);
            if(res < 0) return false;
        }
        return true;
    }
    public int solution(int n, int k, int[] enemy) {
        if (enemy.length <= k) return enemy.length;
        int left = 0 , right = enemy.length;
        int mid;
        int answer = 0;

        while(left <= right){
            mid = (left+right)/2;
            if(checkFunc(n, k, mid, enemy)){
                left = mid + 1;
                answer = mid;
                continue;
            }
            right = mid - 1;
        }
        return answer;
    }
}