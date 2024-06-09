import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i= 0 ; i < n ; i++) nums[i] = Integer.parseInt(inputs[i]);

        Arrays.sort(nums);
        int left ;
        int right ;
        int ans = 0;
        int temp_sum = 0;

        for(int j = 0 ; j < n ; j++){

            right = n - 1;
            left = 0;

            while (left < right) {
                if(left == j) {
                    left++;
                    continue;
                }

                if(right == j){
                    right--;
                    continue;
                }

                temp_sum = nums[right] + nums[left];

                if(temp_sum == nums[j]){
                    ans++;
                    break;
                }
                
                if(temp_sum < nums[j]){
                    left++;
                    continue;
                }
                
                right--;
            }
        }
        System.out.println(ans);
        br.close();
    }
}