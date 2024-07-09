import java.util.HashSet;
import java.util.Set;

class Solution {
     private String convertNumber(int n, int k){
        StringBuilder sb = new StringBuilder();
        if(k == 10) return sb.append(n).toString();
        while(n > 0){
            sb.insert(0,n%k);
            n /= k;
        }
        return sb.toString();
    }

    public boolean isPrime(long num) {
        if(num < 2L) return false;
        if(num == 2L) return true;

        for(long i = 2L; i <= Math.sqrt(num); i++) {
            if(num % i == 0L) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int res = 0;

        for(String str : convertNumber(n, k).split("0")){
            if(str.isEmpty()) continue;
            if(isPrime(Long.parseLong(str))) res++;
        }
        return res;
    }
}
