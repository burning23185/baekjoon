import java.util.*;

public class Solution {
    private static class Reservation implements Comparable<Reservation> {
        private final int start;
        private final int end;

        public Reservation(String start, String end) {
            this.start = convertStrToTime(start);
            this.end = convertStrToTime(end) + 10;
        }

        private int convertStrToTime(String str) {
            String[] time = str.split(":");
            return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Reservation o) {
            return this.start - o.start;
        }
    }

    public int solution(String[][] book_time) {
        List<Reservation> reservations = new ArrayList<>();
        for (String[] time : book_time) reservations.add(new Reservation(time[0], time[1]));
        
        Collections.sort(reservations);

        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        for (Reservation reservation : reservations) {
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= reservation.getStart()) roomEndTimes.poll();
            
            roomEndTimes.add(reservation.getEnd());
        }
        return roomEndTimes.size();
    }
}