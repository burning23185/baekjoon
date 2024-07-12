import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] num_str = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) num_str[i] = String.valueOf(numbers[i]);

        Arrays.sort(num_str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (num_str[0].equals("0")) return "0";

        return String.join("", num_str);
    }
}