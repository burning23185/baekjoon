import java.io.*;

public class Main {
    private static int n;
    private static int[] nums;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        nums = new int[n];
        for(int i = 0 ; i < n ; i++) nums[i] = Integer.parseInt(inputs[i]);

        br.close();
    }

    static int[] calFunc(){
        int[] res = new int[n];
        int count = 0;

        //각 자리수에 해당하는 사람을 구함
        for(int i = 0 ; i < n ; i++){
            count = 0;
            // 해당하는 자리에 누군가 있으면 pass, 누군가 없으면 그 자리가 내자리 인지 확인
            for(int j = 0 ; j < n ; j++){
                if(res[j] != 0) continue;

                if(count == nums[i]){
                    res[j] = i + 1;
                    break;
                }
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        input();
        for(int height : calFunc()) sb.append(height).append(' ');
        System.out.println(sb.toString());
    }
}