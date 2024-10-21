import java.util.*;

class Solution {
    private static class Tickets{
        private final Map<String, Integer> to;
        public Tickets(){
            to = new HashMap<>();
        }
        public boolean addTicket(String ticket){
            this.to.put(ticket, this.to.getOrDefault(ticket, 0)+1);
            return true;
        }
        public boolean removeTicket(String ticket){
            if(!this.to.containsKey(ticket) || this.to.get(ticket) == 0) return false;
            this.to.put(ticket, this.to.get(ticket)-1);
            return true;
        }
    }
    Map<String, List<String>> schedule;
    Map<String, Tickets> stock;

    private boolean dfs(int depth, int length, String now, String[] ans){
        if(depth == length) return true;
        if(schedule.get(now) == null) return false;

        for(String next : schedule.get(now)){
            if(!stock.get(now).removeTicket(next)) continue;

            ans[depth] = next;
            if(dfs(depth+1, length, next, ans)) return true;
            stock.get(now).addTicket(next);
        }
        return false;
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        schedule = new HashMap<>();
        stock = new HashMap<>();

        for(String[] ticket : tickets){
            if(!schedule.containsKey(ticket[0])) schedule.put(ticket[0], new ArrayList<>());
            schedule.get(ticket[0]).add(ticket[1]);
            if(!stock.containsKey(ticket[0])) stock.put(ticket[0], new Tickets());
            stock.get(ticket[0]).addTicket(ticket[1]);
        }
        
        for(String key : schedule.keySet()) Collections.sort(schedule.get(key));

        answer[0] = "ICN";
        dfs(1, tickets.length+1, "ICN", answer);

        return answer;
    }
}