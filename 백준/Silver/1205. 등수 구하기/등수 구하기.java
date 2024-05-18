import java.io.*;
import java.util.Arrays;


public class Main {
    private static int n;
    private static int score;
    private static int p;
    private static int[] nums;

    static boolean input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);

        if(n <= 0){
            System.out.println(1);
            br.close();
            return true;
        }

        score = Integer.parseInt(inputs[1]);
        p = Integer.parseInt(inputs[2]);

        nums = new int[n+1];

        inputs = br.readLine().split(" ");
        for(int i = 0 ; i < n ; i++) nums[i] = Integer.parseInt(inputs[i]);

        br.close();
        return false;
    }

    static int calFunc(){
        int rank = 0;
        int before = -1;
        int temp_count = 1;

        Integer[] temp_nums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(temp_nums, (a, b) -> b - a); 

        for(int i = 0 ; i < nums.length ; i++){

            if (i >= p) return -1;

            if (nums[i] < score) return (before == score) ? rank : rank + temp_count;

            if (before == nums[i]){
                temp_count++;
                continue;
            }

            before = nums[i];
            rank = rank + temp_count;
            temp_count = 1;

        }
        return rank;
    }

    public static void main(String[] args) throws IOException{
        if(input()) return;

        System.out.println(calFunc());
    }
}