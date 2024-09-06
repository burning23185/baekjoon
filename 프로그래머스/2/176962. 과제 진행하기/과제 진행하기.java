import java.util.*;

class Solution {
    static class Subject implements Comparable<Subject>{
        private String title;
        private int startTime;
        private int period;

        public Subject(String title, int startTime, int period){
            this.title = title;
            this.startTime = startTime;
            this.period = period;
        }
        public void updatePeriod(int period){
            this.period = period;
        }

        @Override
        public int compareTo(Subject o) {
            return this.startTime - o.startTime;
        }
    }
    private int parseTimeToMinute(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Subject> subjects = new ArrayList<>();
        Stack<Subject> progress = new Stack<>();

        for(int i = 0 ; i < plans.length ; i++)
            subjects.add(new Subject(plans[i][0], parseTimeToMinute(plans[i][1]), Integer.parseInt(plans[i][2])));

        subjects.sort((Comparator.comparingInt(o -> o.startTime)));

        int cnt = 0;
        int remain;
        Subject temp;
        int time = 0;

        for (Subject subject : subjects) {
            //진행중인 과제 처리
            while (!progress.isEmpty()) {
                remain = time + progress.peek().period - subject.startTime;
                
                if (remain > 0) {
                    progress.peek().updatePeriod(remain);
                    break;
                }

                temp = progress.pop();
                answer[cnt++] = temp.title;
                time += temp.period;
            }
            //현재 과제 진행중에 추가, 현재 시간 갱신
            progress.add(subject);
            time = subject.startTime;
        }
        while(!progress.isEmpty()) answer[cnt++] = progress.pop().title;
        return answer;
    }
}