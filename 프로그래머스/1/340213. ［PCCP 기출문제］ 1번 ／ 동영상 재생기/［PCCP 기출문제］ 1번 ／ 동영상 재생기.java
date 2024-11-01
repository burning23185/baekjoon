import java.util.*;

class Solution {    
    private StringBuilder sb = new StringBuilder();
    
    private int parseTimeToSec(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);  
    }
    
    private String parseSecToTime(int sec){
        int mm = sec/60;
        int ss = sec%60;
        sb.setLength(0);
        if(mm < 10) sb.append('0');
        sb.append(mm).append(':');
        if(ss < 10) sb.append('0');
        sb.append(ss);
        return sb.toString();
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {     
        int op_start_time = parseTimeToSec(op_start);
        int op_end_time = parseTimeToSec(op_end);
        int start_pos = parseTimeToSec(pos);
        int now = ((op_start_time <= start_pos) && (start_pos <= op_end_time)) ? op_end_time : start_pos; 
        int end_video = parseTimeToSec(video_len);
        
        for(String cmd : commands){
            if(cmd.equals("prev")) now = now < 10 ? 0 : now-10;
            else if(cmd.equals("next")) now = now + 10 > end_video ? end_video : now + 10;
            now = ((op_start_time <= now) && (now <= op_end_time)) ? op_end_time : now; 
        }
        
        return parseSecToTime(now);
    }
}