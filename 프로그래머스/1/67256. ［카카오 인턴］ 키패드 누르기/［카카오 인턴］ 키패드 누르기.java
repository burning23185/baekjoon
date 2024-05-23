import java.util.*;

class Position{
    int x;
    int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    private int calLength(int a, int b){
        return (a - b) > 0 ? a-b : b-a;
    }
    
    int getLength(Position target){
        return calLength(this.x,target.x) + calLength(this.y,target.y);
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,Position> keyMap = new HashMap<Integer,Position>();
        int idx = 1;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                 keyMap.put(idx++,new Position(j,3-i));
            }
        }
        keyMap.put(0,new Position(1,0));
        
        Position left = new Position(0,0);
        Position right = new Position(2,0);
        int distance_l = 0;
        int distance_r = 0;
        
        for(int n : numbers){
            if(n == 1 || n ==4 || n == 7){
                left = keyMap.get(n);
                sb.append('L');
            }else if(n == 3||n == 6||n == 9){
                right = keyMap.get(n);
                sb.append('R');
            }else{
                distance_l = left.getLength(keyMap.get(n));
                distance_r = right.getLength(keyMap.get(n));
                    
                if(distance_l == distance_r){
                    if(hand.equals("left")){
                        left = keyMap.get(n);
                        sb.append('L');
                        continue;
                    }
                    right = keyMap.get(n);
                    sb.append('R');
                    continue;
                }
                if(distance_l < distance_r){
                    left = keyMap.get(n);
                    sb.append('L');
                    continue;
                }
                right = keyMap.get(n);
                sb.append('R');
            }
        }
        return sb.toString();
    }
}