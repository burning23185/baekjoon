import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int[] nums;
    private static char[] operator;
    private static int ans;

    private static void dfs(int idx, int temp_ans) {
        if (idx >= operator.length) {
            ans = Math.max(ans, temp_ans);
            return;
        }
        //괄호를 치는 경우
        dfs(idx + 1,  calculate(temp_ans, nums[idx + 1], operator[idx]));

        //괄호를 치지 않는 경우
        if(idx + 2 >= nums.length) return;
        int rear = calculate(nums[idx + 1], nums[idx + 2], operator[idx + 1]);
        dfs(idx + 2, calculate(temp_ans, rear, operator[idx]));
    }

    private static int calculate(int a, int b, char oper) {
        switch (oper){
            case '+':
                return a + b;
            case  '-':
                return a - b;
            case  '*':
                return  a * b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        nums = new int[n/2 + 1];
        operator = new char[n/2];
        ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(i%2 == 0){
                nums[i/2] = expression.charAt(i) - '0';
                continue;
            }
            operator[i/2] = expression.charAt(i);
        }
        dfs(0, nums[0]);
        System.out.println(ans);
    }
}