import java.util.*;

class Solution {
   public int[] solution(int N, int[] stages) {
		Map<Integer, Double> res = new HashMap<>();
		Arrays.sort(stages);
		for(int i = 1; i <= N ; i++) res.put(i, 0.0);
		int count = 0;
		int before = -1;
		int clear_num = 0;
		
		for (int i = 0; i < stages.length; i++) {
			if(stages[i] > N) break;
			
			if(stages[i] == before) {
				count++;
			}else {
				count = 1;
				before = stages[i];
				clear_num = stages.length-i;
			}
			res.put(stages[i],(double)count/clear_num);
		}
		
		List<Integer> keySet = new ArrayList<>(res.keySet());
		keySet.sort((o1, o2) -> res.get(o2).compareTo(res.get(o1)));
		
		return keySet.stream().mapToInt(i->i).toArray();
	}
}