import java.util.*;

class Solution {
    static class User{
        private String name;
        private int reported;
        private boolean ban;

        public User(String name){
            this.name = name;
            this.reported = 0;
            this.ban = false;
        }

        public void increaseReported(){
            this.reported++;
        }

        public void updateBan(boolean ban){
            this.ban = ban;
        }
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<User>> users = new HashMap<>();
        Map<String, User> reported = new HashMap<>();

        for(String id : id_list) {
            users.put(id, new ArrayList<>());
            reported.put(id, new User(id));
        }

        //신고 처리
        Set<String> reports = new HashSet<>();
        String[] temp;
        User reported_user;
        for(String r : report){
            if(!reports.add(r)) continue;

            temp = r.split(" ");
            reported_user = reported.get(temp[1]);
            reported_user.increaseReported();
            users.get(temp[0]).add(reported_user);
        }

        //신고 횟수 기준 정지 처리
        for(String id : id_list){
            if(reported.get(id).reported < k) continue;
            reported.get(id).updateBan(true);
        }

        //신고한 회원 기준 정지 메일수 산정
        int[] answer = new int[id_list.length];
        for(int i = 0 ; i < id_list.length ; i++){
            for(User u : users.get(id_list[i])){
                if(u.ban) answer[i]++;
            }
        }
        return answer;
    }
}