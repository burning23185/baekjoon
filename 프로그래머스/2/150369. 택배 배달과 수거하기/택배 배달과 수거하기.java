class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery_flag = n-1;
        int pickup_flag = n-1;

        for (int i = n - 1; i >= 0; i--) {
            if(deliveries[i] == 0 && pickups[i] == 0) continue;
            int temp = Math.max(deliveries[i], pickups[i]);
            //현재 집의 배달을 완료하기 위한 횟수
            int move_cnt = temp/cap + (temp%cap == 0 ? 0 : 1);
            answer += 2 * move_cnt * (i+1);
            //이동 횟수의 최대 상자를 이동하면서 배달
            int total_box = move_cnt * cap;
            while(delivery_flag >= 0){
                if(total_box - deliveries[delivery_flag] < 0){
                    deliveries[delivery_flag] -= total_box;
                    break;
                }
                total_box -= deliveries[delivery_flag];
                deliveries[delivery_flag--] = 0;
            }
            //이동 횟수의 최대 공간만큼 이동하면서 회수
            int total_pickup = move_cnt * cap;
            while(pickup_flag >= 0){
                if(total_pickup - pickups[pickup_flag] < 0){
                    pickups[pickup_flag] -= total_pickup;
                    break;
                }
                total_pickup -= pickups[pickup_flag];
                pickups[pickup_flag--] = 0;
            }
        }
        return answer;
    }
}