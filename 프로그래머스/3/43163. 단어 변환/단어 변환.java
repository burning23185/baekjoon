import java.util.*;

class Solution {
    private Set<String> visited;
    private Map<String,List<String>> word_map;
    private int ans;
    private void dfs(int depth, String now, String target){
        if(target.equals(now)) {
            ans = Math.min(ans, depth);
            return;
        }
        for(String next : word_map.get(now)){
            if(visited.contains(next)) continue;
            visited.add(next);
            dfs(depth+1, next, target);
            visited.remove(next);
        }
    }
    private boolean checkDiff(String a, String b){
        int diff = 0;
        for(int k = 0 ; k < a.length() ; k++){
            if(a.charAt(k) != b.charAt(k)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
    public int solution(String begin, String target, String[] words) {
        boolean is_exist = false;
        word_map = new HashMap<>();
        visited = new HashSet<>();
        ans = Integer.MAX_VALUE;
        word_map.put(begin, new ArrayList<>());

        for(String word : words) {
            word_map.put(word, new ArrayList<>());
            if (checkDiff(begin, word)) word_map.get(begin).add(word);
        }

        for(int i = 0 ; i < words.length ; i++){
            if(words[i].equals(target)) is_exist = true;

            for(int j = i ; j < words.length ; j++){
                if(checkDiff(words[i], words[j])) {
                    word_map.get(words[i]).add(words[j]);
                    word_map.get(words[j]).add(words[i]);
                }
          }
        }
        if(!is_exist) return 0;
        visited.add(begin);
        dfs(0, begin, target);

        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}