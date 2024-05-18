import java.io.*;

public class Main {
    private static int n;
    private static int target;
    private static int[] nums;
    private static int result;
    private static StringBuilder sb;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        target = Integer.parseInt(inputs[1]);

        nums = new int[n+1];

        inputs = br.readLine().split(" ");
        for(int i = 1 ; i <= n ; i++) nums[i] = Integer.parseInt(inputs[i-1]);

        sb = new StringBuilder();
        br.close();
    }

    static void recFunc(int now, int temp_res){
        if(temp_res + nums[now] == target){
            result++;
        }

        if(now == n){
            return;
        }

        recFunc(now + 1, temp_res + nums[now]);
        recFunc(now + 1, temp_res);
    }

    public static void main(String[] args) throws IOException{
        input();
        recFunc(1, 0);
        System.out.println(result);
    }
}