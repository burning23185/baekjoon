import java.io.*;
import java.util.*;

public class Main {

    private static boolean calFunc(int[] nums, int mid, int target ){
        int temp_res = 0;
        for(int num : nums) temp_res += (num < mid) ? num : mid;

        return temp_res <= target;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] nums = new int[n];

        for(int i = 0; i < n ; i++) nums[i] = Integer.parseInt(temp[i]);      

        int m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = Arrays.stream(nums).max().getAsInt();
        int mid = 0;
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if(calFunc(nums, mid, m)){
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