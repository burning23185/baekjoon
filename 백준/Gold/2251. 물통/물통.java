import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Set<BottleState> visited;
    private static int[] bottle_size;
    private static Set<Integer> ans;

    public static class BottleState{
        private int[] nums;
        public BottleState(int[] nums){
            this.nums = nums;
        }

        public int getState(int idx){
            return idx < nums.length ? this.nums[idx] : 0;
        }
        public void updateState(int idx, int value){
            this.nums[idx] = value;
        }
        public int[] copyState(){
            return this.nums.clone();
        }
        public int getSize(){
            return nums.length;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BottleState that = (BottleState) o;
            return Arrays.equals(nums, that.nums);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(nums);
        }
    }

    private static void dfs(BottleState bottleState){
        visited.add(bottleState);
        if(bottleState.getState(0) == 0) ans.add(bottleState.getState(bottleState.getSize()-1));

        int remain_target;
        int remian_start;

        for(int i = 0 ; i < bottleState.getSize() ; i++){
            if(bottleState.getState(i) == 0) continue;

            for(int j = 0 ; j < bottleState.getSize() ; j++){
                if(i == j) continue;

                if(bottleState.getState(i) + bottleState.getState(j) > bottle_size[j]){
                    //부었을때, 대상의 물통이 넘치는 경우
                    remain_target = bottle_size[j];
                    remian_start = bottleState.getState(i) + bottleState.getState(j) - bottle_size[j];
                }else{
                    remain_target = bottleState.getState(i) + bottleState.getState(j);
                    remian_start = 0;
                }

                BottleState next = new BottleState(bottleState.copyState());
                next.updateState(j, remain_target);
                next.updateState(i, remian_start);

                if(visited.contains(next)) continue;
                dfs(next);
            }// for
        }// for
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs =  br.readLine().split(" ");
        int size = inputs.length;
        ans = new TreeSet<>();
        bottle_size = new int[size];

        for(int i = 0 ; i < size; i++) bottle_size[i] = Integer.parseInt(inputs[i]);

        visited = new HashSet<>();
        dfs(new BottleState(new int[]{0, 0, bottle_size[size-1]}));

        for(int n : ans) sb.append(n).append(' ');

        System.out.println(sb);
        br.close();
    }
}