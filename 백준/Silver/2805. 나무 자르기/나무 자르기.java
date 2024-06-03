import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        String[] inputs = br.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i < n ; i++) nums.add(Integer.parseInt(inputs[i]));

        int left = 0;
        int right = 2_000_000_000;
        int mid = 0;
        int answer = 0;
        double temp_res = 0;

        while(left <= right){
            temp_res = 0;
            mid = (left + right) / 2; 

            for(int num : nums) temp_res += num > mid ? (num - mid) : 0;
            
            if(temp_res >= m){
                answer = mid;
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        
        System.out.println(answer);
        br.close();
    }
}