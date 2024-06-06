import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n =  Integer.parseInt(temp[0]);
        int w = Integer.parseInt(temp[1]);
        int l = Integer.parseInt(temp[2]);

        int[] trucks = new int[n];
        String[] inputs = br.readLine().split(" ");

		for(int i= 0 ; i < n ; i++) trucks[i] = Integer.parseInt(inputs[i]);
	
		Queue<Integer> queue = new LinkedList<>();
        for(int j = 0 ; j < w ; j++) queue.add(0);

		int answer = 0;
		int total_weight = 0;
        int truck_num = 0;

        while(!queue.isEmpty()){
            answer++;
            total_weight -= queue.poll();

            if(truck_num == n) continue;

            int next = (total_weight + trucks[truck_num] > l) ? 0 : trucks[truck_num++];
            queue.offer(next);
            total_weight += next;
        }

        System.out.println(answer);
        br.close();
    }
}