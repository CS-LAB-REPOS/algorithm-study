import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        List<List<String>> kind = new ArrayList<>();
        int result=1;
        //종류별로 정리
        for(String[] i : clothes){
            boolean hasKind = false;
            
            for(int j = 0 ; j<kind.size(); j ++){
                if(kind.get(j).get(0).equals(i[1])){
                    hasKind = true;
                    kind.get(j).add(i[0]);
                    break;
                }
            }
            //kind 리스트에 옷 종류가 없으면 add추가.
            if(!hasKind){
                List<String> temp = new ArrayList<>();
                temp.add(i[1]); temp.add(i[0]);
                kind.add(temp);
            }
        }
        
        for(List<String> i : kind){
            result *=i.size();
        }
        
        //경우의 수 구하기
        answer = result-1;
        return answer;
    }
}