class Solution {
    int[] discounts;
    int[] res;
    private void checkCondition(int[][] users, int[] emoticons){
        int[] temp_res = new int[]{0, 0};

        for (int[] user : users) {
            double totalBuy = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (user[0] <= discounts[i]) // 사용자의 구매 조건을 만족하는 경우
                    totalBuy += emoticons[i] * (100 - discounts[i]) / 100.0;
            }

            if (totalBuy >= user[1]) temp_res[0]++;
            else temp_res[1] += (int) totalBuy;
        }
        // 플러스 가입자 수가 더 많거나, 동일한 경우 더 많은 이익이면 갱신
        if (temp_res[0] > res[0] || (temp_res[0] == res[0] && temp_res[1] > res[1])) res = temp_res;
    }
    private void countAvailable(int[][] users, int[] emoticons, int depth) {
        if (depth == emoticons.length) {
            checkCondition(users, emoticons);
            return;
        }

        // 40%, 30%, 20%, 10% 할인율을 순차적으로 적용
        for (int i = 40; i >= 10; i -= 10) {
            discounts[depth] = i;
            countAvailable(users, emoticons, depth + 1);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        discounts = new int[emoticons.length];
        res = new int[]{0, 0};

        countAvailable(users, emoticons, 0);
        return res;
    }
}