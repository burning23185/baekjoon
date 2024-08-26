import java.util.*;

class Solution {
    private long answer;
    private char[] op;
    private boolean[] visited ;
    private ArrayList<Long> num_list;
    private ArrayList<Character> op_list;

    private void recFunc(int depth, char[] cmd){
        if(depth == op.length){
            answer = Math.max(answer, calFunc(cmd));
            return;
        }

        for(int i=0; i<op.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            cmd[depth] = op[i];
            recFunc(depth+1, cmd);
            visited[i] = false;
        }
    }

    private long calFunc(char[] cmd){
        ArrayList<Character> ops = new ArrayList<>(op_list);
        ArrayList<Long> nums = new ArrayList<>(num_list);

        for(char oper : cmd){
            int cnt = 0;
            while(cnt < ops.size()){
                if(ops.get(cnt) != oper){
                    cnt++;
                    continue;
                }

                long res = 0;
                long a = nums.get(cnt);
                long b = nums.get(cnt+1);

                if(oper == '*') res = a * b;
                else if(oper == '+') res = a + b;
                else if(oper== '-') res = a - b;

                nums.set(cnt, res);
                nums.remove(cnt+1);
                ops.remove(cnt);
            }
        }
        return Math.abs(nums.get(0));
    }

    public long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        op = new char[]{'+','-','*'};
        visited = new boolean[op.length];
        num_list = new ArrayList<>();
        op_list = new ArrayList<>();
        answer = 0;

        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) >= '0'){
                sb.append(expression.charAt(i));
                continue;
            }
            op_list.add(expression.charAt(i));
            num_list.add(Long.parseLong(sb.toString()));
            sb.setLength(0);
        }
        num_list.add(Long.parseLong(sb.toString()));
        sb.setLength(0);
        recFunc(0, new char[op.length]);

        return answer;
    }
}