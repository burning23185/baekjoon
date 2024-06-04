import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<Integer> nums = new HashSet<>();

        String[] temp = br.readLine().split(" ");        

        for(int i = 0; i < n ; i++) nums.add(Integer.parseInt(temp[i]));

        int m = Integer.parseInt(br.readLine());

        String[] target_nums = br.readLine().split(" ");

        for(int j = 0 ; j < m ; j++) sb.append(nums.contains(Integer.parseInt(target_nums[j])) ? 1 : 0).append('\n');
        
        System.out.println(sb.toString());
        br.close();
    }
}