import java.util.*;

class Solution {
    public int[] solution(String s) {
        int start = 0;
        int size = 0;

        List<String[]> str_nums = new ArrayList<>();
        Set<Integer> num_set = new HashSet<>();

        for(int i = 1 ; i < s.length()-1 ; i++){
            if(s.charAt(i) == '{'){
                start = i + 1;
                continue;
            }
            if(s.charAt(i) == '}') {
                String[] strs = s.substring(start, i).split(",");
                size = Math.max(size, strs.length);
                str_nums.add(strs);
            }
        }

        int[] answer = new int[size];
        int cnt = 0;
        int temp;
        Collections.sort(str_nums, (a, b) -> a.length - b.length);

        for(String[] strs : str_nums){
            for(String str : strs){
                temp = Integer.parseInt(str);
                if(num_set.add(temp)) answer[cnt++] = temp;
            }
        }
        return answer;
    }
}