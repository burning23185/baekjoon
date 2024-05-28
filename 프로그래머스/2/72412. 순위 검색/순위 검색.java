import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    Map<String, List<Integer>> applicantMap;
    Map<String, Boolean> isSortedMap;

    public Solution(){
        this.applicantMap = new HashMap<>();
        this.isSortedMap = new HashMap<>();
        List<String[]> categorys = new ArrayList<>();
        categorys.add(new String[]{"cpp", "java", "python", "-"});
        categorys.add(new String[]{"backend", "frontend", "-"});
        categorys.add(new String[]{ "junior", "senior", "-"});
        categorys.add(new String[]{ "chicken", "pizza", "-"});

        this.initApplicantMap(categorys, 0 , "");
    }

    // HashMap 초기화
    private void initApplicantMap(List<String[]> categorys, int depth, String res){
        if(depth == 4){
            this.applicantMap.put(res, new ArrayList<>());
            this.isSortedMap.put(res, false);
            return;
        }
        for(String keys : categorys.get(depth)){
            initApplicantMap(categorys, depth+1, res.concat(keys));
        }
    }

    // 지원자 정보 HashMap에 입력
    private void input(String[] data, int depth, String res){
        if(data.length != 5) return;

        if(depth == 4){
            applicantMap.get(res).add(Integer.parseInt(data[depth]));
            return;
        }

        input(data, depth + 1, res.concat(data[depth]));
        input(data, depth + 1, res.concat("-"));
    }

    //쿼리문 HashMap 입력 및 이진 탐색으로 결과 출력
    private int doQuery(String[] query){
        StringBuilder temp_res = new StringBuilder();

        temp_res.append(query[0]).append(query[2]).append(query[4]).append(query[6]);

        String key = temp_res.toString();

        List<Integer> temp_list = this.applicantMap.get(key);
        if(!isSortedMap.get(key)){
            Collections.sort(temp_list);
            isSortedMap.put(key, true);
        } 
        return this.binarySearch(temp_list, Integer.parseInt(query[7]));
    }

    private int binarySearch(List<Integer> nums, int target){
        int left = 0;
        int right = nums.size()-1;
        int mid = (left + right) / 2;

        while(left <= right){
            mid = (left + right) / 2;

            if(nums.get(mid) < target){
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        return nums.size() - left;
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        //info를 Applicant로 Map 으로 입력 및 result set 으로 입력
        for(String data : info) this.input(data.split(" "), 0, "");
            
        //query 실행
        for(int i = 0 ; i < query.length ; i++) answer[i] = this.doQuery(query[i].split(" "));
            
        return answer;
    }
}