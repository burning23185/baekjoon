import java.io.*;
import java.util.*;

public class Main {

    private static boolean calFunc(int[] nums, long mid, int target ){
        long temp_res = 0;
        for(int num : nums){
            temp_res += num / mid; 

            if(temp_res >= target) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");        
        int k = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        int[] nums = new int[k];

        for(int i = 0; i < k ; i++) nums[i] = Integer.parseInt(br.readLine());

        long left = 1;
        long right = Integer.MAX_VALUE;
        long mid = 0;
        long answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if(calFunc(nums, mid, n)){
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