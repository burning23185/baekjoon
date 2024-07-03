import java.io.*;

public class Main {
    private static int checkPal(String str, int s, int e, int rm_cnt){
        if (rm_cnt >= 2) return 2;

        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
                continue;
            }
            return Math.min(checkPal(str,s+1, e, rm_cnt+1), checkPal(str, s, e-1, rm_cnt+1));
        }
        return rm_cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String input;

        for(int i = 0 ; i < t; i++){
            input = br.readLine();
            sb.append(checkPal(input,0,input.length()-1,0)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
