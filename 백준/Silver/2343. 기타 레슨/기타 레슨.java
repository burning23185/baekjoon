import java.io.*;
import java.util.*;

public class Main {

    private static boolean calFunc(int[] nums, int mid, int target ){
        int temp_res = 0;
        int count = 1;
        for(int num : nums) {
            if(temp_res + num > mid){
                count++;
                temp_res = num;
                continue;
            }
            temp_res += num;
        }
        return count <= target;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] temp = br.readLine().split(" ");
        int n =  Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[n];

        for(int i = 0; i < n ; i++) nums[i] = Integer.parseInt(inputs[i]);      

        int left = Arrays.stream(nums).max().getAsInt();
        int right = 1_000_000_000;
        int mid = 0;
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if(calFunc(nums, mid, m)){
                answer = mid;
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        System.out.println(answer);
        br.close();
    }
}