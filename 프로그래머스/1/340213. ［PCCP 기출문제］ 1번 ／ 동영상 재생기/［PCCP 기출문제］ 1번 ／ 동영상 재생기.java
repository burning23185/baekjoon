import java.util.*;

class Solution {        
    private int parseTimeToSec(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);  
    }
    
    private String parseSecToTime(int sec){
        int mm = sec/60;
        int ss = sec%60;
        String res = "";
        
        if(mm < 10) res += "0";
        res += mm + ":";
        if(ss < 10) res += "0";
        res += ss;
        return res;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {     
        int[] op_time = new int[]{parseTimeToSec(op_start), parseTimeToSec(op_end)};
        int start_pos = parseTimeToSec(pos);
        int now = ((op_time[0] <= start_pos) && (start_pos <= op_time[1])) ? op_time[1] : start_pos; 
        int end_video = parseTimeToSec(video_len);
        
        for(String cmd : commands){
            if(cmd.equals("prev")) now = Math.max(now - 10, 0);
            else if(cmd.equals("next")) now = Math.min(now + 10, end_video); 
            now = ((op_time[0] <= now) && (now <= op_time[1])) ? op_time[1] : now; 
        }
        
        return parseSecToTime(now);
    }
}