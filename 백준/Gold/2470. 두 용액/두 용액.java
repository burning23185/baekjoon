import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        List<Integer> nums = new ArrayList<>(100_000);

        for(int i = 0; i < n ; i++) nums.add(Integer.parseInt(temp[i]));
        Collections.sort(nums);

        int left = 0;
        int right = n-1;
        int[] res = new int[2];

        int near_zero = 2_000_000_001;
        int temp_min = 0;
        int flag = 1;

        while(left < right){
            temp_min = nums.get(left) + nums.get(right);

            if(temp_min == 0){
                res[0] = nums.get(left);
                res[1] = nums.get(right);
                break;
            }

            flag = temp_min > 0 ? 1 : -1;

            // 0 에 더 근접하면 정답 갱신
            if(temp_min * flag < near_zero){
                res[0] =  nums.get(left);
                res[1] =  nums.get(right);
                near_zero = temp_min * flag;
            }

            if(flag > 0){
                right--;
                continue;
            }
            left++;
        }
        System.out.println(sb.append(res[0]).append(' ').append(res[1]).toString());
        br.close();
    }
}