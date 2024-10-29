
class Solution {

    private boolean recFunc(String s, int target){
        if(target == 1) return true;
        int half_len = target/2;
        int c = target%2 == 0 ? -1 : 0;
        boolean res = false;

        for(int i = 0 ; i+target <= s.length() ; i++){
            for(int j = 1 ; j <= half_len; j++){
                if(s.charAt(i + half_len - j) != s.charAt(i + half_len + j + c)) {
                    res = false;
                    break;
                }
                res = true;
            }
            if(res) break;
        }
        return res;
    }
    public int solution(String s)
    {
        int answer = s.length();
        while(!recFunc(s, answer)){
            answer--;
        }
        return answer;
    }
}