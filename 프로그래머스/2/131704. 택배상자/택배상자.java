import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int flag = 0;

        for(int i = 1 ; i <= order.length ; i++){
            if(order[flag] != i){
                s.push(i);
                continue;
            }
            //만약 매인 컨베이어가 트럭에 실어야 하는 순번이 오면 트럭에 넣고 다음 실어야 할 택배의 번호를 확인한다.
            flag++;
            answer++;

            //만약 서브 컨베이어에 다음 실어야할 택배 박스가 있다면 트럭에 넣는다.
            while(s.size() > 0 && s.peek() == order[flag]){
                s.pop();
                flag++;
                answer++;
            }
        }
        return answer;
    }
}