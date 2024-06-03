import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        List<Integer> nums = new ArrayList<>();

        for(int i = 0; i < n ; i++) nums.add(Integer.parseInt(br.readLine()));

        Collections.sort(nums);

        int left = 0;
        int right = 1_000_000_000;
        int mid = 0;
        int before = 0;
        int answer = 0;
        int temp_res = 1;

        while(left <= right){
            before = nums.get(0);
            temp_res = 1;
            mid = (left + right) / 2; 

            for(int j = 1 ; j < n ; j++){
                if(nums.get(j) - before < mid) continue;

                temp_res++;
                before = nums.get(j);
            }
            
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