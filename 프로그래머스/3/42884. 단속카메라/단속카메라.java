import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    private static class Car implements Comparable<Car>{
        int route_in;
        int route_out;
        public Car(int route_in, int route_out){
            this.route_in = route_in;
            this.route_out = route_out;
        }

        public int getRouteIn() {
            return this.route_in;
        }

        public int getRouteOut() {
            return this.route_out;
        }

        @Override
        public int compareTo(Car o) {
            return  o.getRouteOut() - this.getRouteOut();
        }
    }

    public int solution(int[][] routes) {
            PriorityQueue<Car> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0 ; i < routes.length ; i++) pq.add(new Car(routes[i][0], routes[i][1]));

            Car now;
            int ans = 0;
            int before = - 30_001;

            while(pq.size() > 0){
                now = pq.poll();
                if(before >= now.getRouteIn()) continue;
                before = now.getRouteOut();
                ans++;
            }
            return ans;
    }
}