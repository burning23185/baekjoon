class Solution {
    private int[] ans;
    private int[][] arr;
    
    public boolean checkTheOne(int x, int y, int size, int val) {
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != val) return false;
            }
        }
        return true;
    }
    public void quad(int x, int y, int size){
        //만약 1개의 숫자로 압축가능한 경우
        if(checkTheOne(x, y, size, arr[x][y])){
            if(arr[x][y] == 1) ans[1]++;
            else ans[0]++;
            return;
        }
        
        int half = size/2;
        quad(x, y, half);
        quad(x,y + half, half);
        quad(x+half, y, half);
        quad(x+half, y + half, half);
    }
    public int[] solution(int[][] arr) {
        ans = new int[2];
        this.arr = arr;
        quad(0, 0, arr.length);
        return ans;
    }
}