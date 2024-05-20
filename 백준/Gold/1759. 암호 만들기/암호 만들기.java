import java.io.*;
import java.util.Arrays;

public class Main {
    private static int l;
    private static int c;
    private static char[] char_list;
    private static StringBuilder sb;
    private static char[] vowel = {'a', 'e', 'i', 'o', 'u'};

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        l = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);
        char_list = new char[c];
        sb = new StringBuilder();

        String temp = br.readLine();
        for(int i = 0 ; i < 2*c ; i = i+2) char_list[i/2] = temp.charAt(i); 

        br.close();
    }

    static boolean isAvailable(StringBuilder temp_str){
        int vowel_num = 0;
        for(char v : vowel) vowel_num = (temp_str.indexOf(String.valueOf(v)) == -1) ? vowel_num : vowel_num + 1;
        
        return vowel_num >= 1 && (l - vowel_num) >= 2;
    }

    static void recFunc(int now, StringBuilder temp_str){
        if(temp_str.length() == l) {
            if(isAvailable(temp_str)) sb.append(temp_str).append('\n');
            return;
        }

        for(int i = now ; i < c ; i++){
            temp_str.append(char_list[i]);
            recFunc(i + 1, temp_str);
            temp_str.deleteCharAt(temp_str.length()-1);
        }
    }

    public static void main(String[] args) throws IOException{
        StringBuilder temp_str = new StringBuilder();
        input();
        Arrays.sort(char_list);
        recFunc(0, temp_str);
        System.out.println(sb.toString());
    }
}