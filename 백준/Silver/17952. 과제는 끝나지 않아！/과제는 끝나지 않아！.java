import java.io.*;
import java.util.*;

public class Main {
    static class Subject{
        private int score;
        private int time;

        public Subject(int score, int time){
            this.score = score;
            this.time = time;
        }

        public int doSubject(){
            return --this.time;
        }
        public int getScore(){
            return this.score;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Subject> subjects = new Stack<>();
        Subject now = null;
        int answer = 0;
        
        for(int i = 0 ; i < n ; i++){
            String[] temp = br.readLine().split(" ");
            
            //과제가 들어오지 않은 경우
            if(temp.length <= 1){
                if(now == null) continue;
                 // 진행중인 과제를 1번 수행하고 완료되었는지 확인
                
                if(now.doSubject() == 0){
                answer += now.getScore();
                now = subjects.isEmpty() ? null : subjects.pop();
                }
                continue;
            }

            //과제가 들어온 경우

            int score = Integer.parseInt(temp[1]);
            int time = Integer.parseInt(temp[2]);
                
            // 즉시 완료 가능한지 확인
            if(time == 1) {
                answer += score;
                continue;
            }

            // 진행중이던 과제가 있는 경우 stack에 보관 
            if(now != null) subjects.push(now);

            now = new Subject(score, time);
            now.doSubject();   
        }
        System.out.println(answer);
    }
}