import java.util.*;
class Solution {
    private int calTime(String in, String out){
        return (out.charAt(0)-in.charAt(0))*600 + (out.charAt(1)-in.charAt(1))*60
                    + (out.charAt(3)-in.charAt(3))*10 + (out.charAt(4)-in.charAt(4));
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, String> in = new HashMap<>();
        Map<String, Integer> park_time = new TreeMap<>();
            
        //차량 정보 저장 및 출차 시 주차 시간 저장
        for(String record : records){
            String[] line = record.split(" ");
            if(line[2].equals("IN")){
                in.put(line[1], line[0]);
                continue;
            }
            park_time.put(line[1], park_time.getOrDefault(line[1],0) + calTime(in.get(line[1]), line[0]));
            in.remove(line[1]);
        }

        //출차 기록이 없는 차량 정산
        for(String k : in.keySet()) {
            park_time.put(k, park_time.getOrDefault(k, 0) + calTime(in.get(k), "23:59"));
        }
        // 요금 환산 및 결과 저장
        int[] ans = new int[park_time.size()];
        int minute;
        Iterator<String> iter = park_time.keySet().iterator();
        int cnt = 0;
        while (iter.hasNext()){
            String str = iter.next();
            minute =  park_time.get(str) - fees[0];
            if(minute < 0){
                ans[cnt++] = fees[1];
                continue;
            }
            ans[cnt++] = fees[1] + ((minute/fees[2] + (minute%fees[2] == 0 ? 0 :1))*fees[3]);
        }
        return ans;
    }
}
