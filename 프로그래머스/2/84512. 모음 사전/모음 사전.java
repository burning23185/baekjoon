public class Solution {
    private int cnt;

    private boolean dfs(String now, String target, String alpha){        
        if(now.equals(target)) return true;
        cnt++;
        if(now.length() == 5) return false;

        for(int i = 0 ; i < alpha.length() ; i++) if(dfs(now + alpha.charAt(i), target, alpha)) return true;
        
        return false;
    }

    public int solution(String word) {
        cnt = 0;
        dfs("", word, "AEIOU");
        return cnt;
    }
}