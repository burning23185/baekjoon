import java.util.HashMap;
import java.util.Map;

class Solution {
    private String[] board;
    private Map<Character, Boolean> winner;
    private void checkWinner(){
        for(int i = 0 ; i < board.length ; i++){
            if(checkCol(i)) winner.put(board[0].charAt(i), true);
            if(checkRow(i)) winner.put(board[i].charAt(0), true);
        }
        checkCross();
    }

    private boolean checkRow(int idx){
        char before = board[idx].charAt(0);
        for(int i = 1 ; i < board[0].length() ; i++){
            if(before != board[idx].charAt(i) || board[idx].charAt(i) == '.') return false;
        }
        return true;
    }
    private boolean checkCol(int idx){
        char before = board[0].charAt(idx);
        for(int i = 1 ; i < board[0].length() ; i++){
            if(before != board[i].charAt(idx) || board[i].charAt(idx) == '.') return false;
        }
        return true;
    }
    private void checkCross(){
        char before = board[0].charAt(0);
        boolean res = false;
        char now;
        for(int i = 1 ; i < board[0].length() ; i++){
            now = board[i].charAt(i);
            if(before != now || now == '.'){
                res = false;
                break;
            }
            res = true;
        }

        if(res) winner.put(before, true);

        before = board[0].charAt(board.length-1);
        for(int i = board.length-2 ; i >= 0 ; i--){
            now = board[board.length - i - 1].charAt(i);
            if(before != now || now == '.') {
                res = false;
                break;
            }
            res = true;
        }
        if(res) winner.put(before, true);
    }
    public int solution(String[] board) {
        this.board = board;
        winner = new HashMap<>();

        int cnt_o = 0;
        int cnt_x = 0;

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length() ; j++){
                if(board[i].charAt(j) == 'O'){
                    cnt_o++;
                }else if(board[i].charAt(j) == 'X'){
                    cnt_x++;
                }
            }
        }
        checkWinner();
        if(winner.containsKey('O') && winner.containsKey('X')) return 0;
        if(winner.containsKey('O')) return (cnt_o == cnt_x+1) ? 1 : 0;
        if(winner.containsKey('X')) return (cnt_o == cnt_x) ? 1 : 0;
        return (cnt_o == cnt_x || cnt_o == cnt_x+1) ? 1 : 0;
    }
}