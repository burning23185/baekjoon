class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);
        int nextNum = n + 1;

        while (Integer.bitCount(nextNum) != targetCount) {
            nextNum++;
        }

        return nextNum;
    }
}