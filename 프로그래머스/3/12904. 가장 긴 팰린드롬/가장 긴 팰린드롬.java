class Solution {
    public int solution(String s) {
        int maxLength = 1;
        
        for (int center = 0; center < s.length(); center++) {
            maxLength = Math.max(maxLength, expandAroundCenter(s, center, center));
            maxLength = Math.max(maxLength, expandAroundCenter(s, center, center + 1));
        }

        return maxLength;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}