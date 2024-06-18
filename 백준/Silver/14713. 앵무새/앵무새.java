import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String[]> spells = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) spells.add(br.readLine().split(" "));

        int[] flag = new int[n];
        boolean isContains = false;
        boolean ans = false;
        String[] temp;

        for(String str : br.readLine().split(" ")){
            isContains = false;
            for(int j = 0 ; j < n ; j++){
                temp = spells.get(j);
                // 이미 포인터가 끝까지 이동한 경우 다음 앵무새 말로 넘어감
                if(flag[j] == temp.length) continue;
                // 만약 앵무새말에 L 의 단어와 일치하는 경우 다음 L 단어로 이동
                isContains = temp[flag[j]].equals(str);
                if(isContains) {
                    flag[j]++;
                    break;
                }
            }
            if(!isContains) break;
        }
        //앵무새 말을 다 사용했는지 확인
        if(isContains){
            ans = true;
            for(int k = 0 ; k < n ; k++) {
                if (flag[k] < spells.get(k).length){
                    ans = false;
                    break;
                }
            }
        }
        System.out.println(ans ? "Possible" : "Impossible");
    }
}