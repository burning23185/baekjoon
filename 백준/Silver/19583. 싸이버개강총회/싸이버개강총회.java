import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] times = br.readLine().split(" "); 
        String input;
        Set<String> check_in = new HashSet<>();
        int ans = 0;

        while((input = br.readLine()) != null){
            String[] msg = input.split(" ");

            //스트리밍이 끝난 후 채팅 기록은 더 이상 확인 X
            if(times[2].compareTo(msg[0]) < 0) break;

            //시작 전 채팅일 경우 체크인
            if(times[0].compareTo(msg[0]) >= 0){
                check_in.add(msg[1]);
                continue;
            }

            //총회 시간은 지나감
            if(times[1].compareTo(msg[0]) > 0) continue;
            
            // 체크 아웃 확인 시간
            if(check_in.contains(msg[1])){
                ans++;
                check_in.remove(msg[1]);
            }
        }
        System.out.println(ans);
    }
}