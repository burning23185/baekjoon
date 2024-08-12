import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character,Integer> alpha_map = new HashMap<>();

        int t = Integer.parseInt(br.readLine());
        String input_str;

        for(int i = 0 ; i < t ; i++) {
            input_str = br.readLine();
            for (int j = 0; j < input_str.length(); j++) {
                int val = (int) Math.pow(10, input_str.length()-j-1);
                alpha_map.put(input_str.charAt(j), val + alpha_map.getOrDefault(input_str.charAt(j), 0));
            }
        }

        int cnt = 9;
        long ans = 0;

        for(int val : alpha_map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            ans += (long) val * cnt--;
        }

        System.out.println(ans);
        br.close();
    }
}