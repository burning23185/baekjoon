import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] temp = br.readLine().split(" ");
        int n =  Integer.parseInt(temp[1]);
        int m = Integer.parseInt(temp[0]);

        Set<String> click_list = new LinkedHashSet<>();

        for(int i = 0; i < n ; i++) {
            String input = br.readLine();
            if(click_list.contains(input)) click_list.remove(input);
            click_list.add(input);
        }

        for(String str : click_list){
            sb.append(str).append('\n');
            if(--m == 0) break;
        }

        System.out.println(sb.toString());
        br.close();
    }
}