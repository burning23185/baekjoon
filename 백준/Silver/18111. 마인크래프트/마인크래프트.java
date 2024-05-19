import java.io.*;

public class Main {
    private static int n;
    private static int m;
    private static int b;
    private static int[][] nums;

    static int[] input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        b = Integer.parseInt(inputs[2]);

        int min = 255;
        int max = 0;

        nums = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            inputs = br.readLine().split(" ");

            for(int j = 0 ; j < inputs.length ; j++){
                nums[i][j] = Integer.parseInt(inputs[j]);
                min = nums[i][j] < min ? nums[i][j] : min;
                max = nums[i][j] > max ? nums[i][j] : max;
            }
        }
        br.close();
        return new int[]{min, max};
    }

    //target 높이까지 평탄화에 걸리는 시간 계산 (해당 높이를 만들 수 없는 경우 return -1)
    static int smoothFunc(int target){
        int add_block = 0;
        int sub_block = 0;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums[0].length ; j++){
                if (nums[i][j] > target){
                    sub_block += nums[i][j] - target; 
                    continue;
                }
                add_block += target - nums[i][j];
            }
        }
        return (sub_block - add_block + b) >= 0 ? (sub_block*2 + add_block) : -1;
    }

    //0 ~ 256 높이 까지 평탄화 시도 후 최소시간 및 높이 반환
    static int[] calFunc(int min, int max){
        int min_time = Integer.MAX_VALUE;
        int res = 0;
        int temp_res = 0;

        for(int i = min ; i <= max ; i++){

            temp_res = smoothFunc(i);
            if(temp_res < 0) break; 

            if(temp_res > min_time) continue;

            res = i;
            min_time = temp_res;
        }

        return new int[]{min_time, res}; 
    }


    public static void main(String[] args) throws IOException{
        int[] min_max = input();
        int[] result = calFunc(min_max[0], min_max[1]);
        System.out.println(String.format("%d %d", result[0], result[1]));
    }
}