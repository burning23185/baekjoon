import java.util.*;

class Solution {
    public int solution(String name) {
        Map<Character,Integer> keyMap = new HashMap<>();

        for(int i = 0 ; i < 13 ; i++){
            keyMap.put((char) ('A' + i), i);
            keyMap.put((char) ('Z' - i), i+1);
        }
        
        int length = name.length();
        int end_idx;
        int move_horizontal = length - 1;
        int move_vertical = 0;

        for(int i = 0; i < name.length(); i++){
            move_vertical += keyMap.get(name.charAt(i));

            end_idx = i + 1;
            while(end_idx < length && name.charAt(end_idx) == 'A'){
                end_idx++;
            }
            // 왼쪽에서 오른쪽으로
            move_horizontal = Math.min(move_horizontal, i * 2 + length - end_idx);
            // 오른쪽에서 왼쪽으로
            move_horizontal = Math.min(move_horizontal, (length - end_idx) * 2 + i);

        }
        return move_vertical + move_horizontal;
    }
}