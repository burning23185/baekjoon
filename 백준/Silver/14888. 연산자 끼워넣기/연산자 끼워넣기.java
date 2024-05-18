import java.io.*;

public class Main {
    private static int n;
    private static int max;
    private static int min;
    private static int[] nums;
    private static int[] ops;
    private static StringBuilder sb;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        nums = new int[n+1];
        ops = new int[5];

        String[] inputs = br.readLine().split(" ");
        for(int i = 1 ; i <= n ; i++) nums[i] = Integer.parseInt(inputs[i-1]);

        inputs = br.readLine().split(" ");
        for(int j = 1 ; j <= 4 ; j++) ops[j] = Integer.parseInt(inputs[j-1]);

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        sb = new StringBuilder();
        br.close();
    }

    static void recFunc(int now, int temp_res){

        if(now == n){
            max = max < temp_res ? temp_res : max;
            min = min > temp_res ? temp_res : min;
            return;
        } 
        
        for(int i = 1 ; i <= 4 ; i++){
            if (ops[i] == 0) continue;

            ops[i]--;
            recFunc(now + 1, calFunc(temp_res, nums[now+1], i));
            ops[i]++;
        }
    }

    static int calFunc(int a, int b, int ops){
        if(ops == 1) return a + b;
        if(ops == 2) return a - b;
        if(ops == 3) return a * b;
        if(ops == 4) return a / b;
        return 0;
    }

    public static void main(String[] args) throws IOException{
        input();
        recFunc(1, nums[1]);
        System.out.println(sb.append(max).append('\n').append(min).toString());
    }  
}