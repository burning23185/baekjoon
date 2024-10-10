class Solution {
    private long pow(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public long addBeforeIdx(int n, long end, long total_length, long total_one){
        if (n == 1) return end <= 2 ? end : end - 1;

        //5 개 묶음으로 변환
        // n = 0 -> 1 (A)
        // n = 1 -> 11011 (AA0AA) -> B
        //         /part 0   /part 1   /part 2   /part 3   /part 4
        // n = 2 -> 11011     11011     00000     11011     11011  (BB00000BB)
        // 5^n 만큼 길이가 늘어나므로 5^(n-1) 길이로 나누면 5 등분이 됨

        long block_len = total_length/5; // 5 등분한 1 덩어리의 길이
        long block_sum = total_one/4; // 5등분한 1 덩어리의 1의 총 갯수
        long end_part = end / block_len + ((end % block_len == 0) ? -1 : 0); // 인덱스 이므로 나누어서 딱 덜어지는 경우 -1 더함

        //ex> 종료 지점이 part1인 경우 part0 + part 1 (끈긴해당 인덱스까지 1의 갯수의 합)
        long next_end = end - end_part * block_len;
        if (end_part < 2)
            return (block_sum * end_part) + addBeforeIdx(n - 1, next_end, block_len, block_sum);
        //종료 지점에 part2 인경우 0으로 차있으므로 나눈 등분합 * 2
        if (end_part == 2)
            return block_sum * 2;
        //ex> 종료 지점이 part4 인 경우 (3 덩어리의 1의 갯수합) + part4 (4번째 덩어리의 끈긴 지점까지 1의 갯수합)
        return block_sum * (end_part - 1) + addBeforeIdx(n - 1, next_end, block_len, block_sum);
    }

    public int solution(int n, long l, long r) {
        long total_length = pow(5, n);
        long total_one = pow(4, n);
        return (int) (addBeforeIdx(n, r, total_length, total_one) - addBeforeIdx(n,l-1, total_length, total_one));
    }
}