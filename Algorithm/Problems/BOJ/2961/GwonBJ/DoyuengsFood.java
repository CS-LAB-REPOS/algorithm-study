import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoyuengsFood {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        boolean[] includes = new boolean[N];
        int[][] ingredients = new int[N][2];
        //재료정보 받아오기
        for(int i = 0; i < N ; i++){
            ingredients[i][0] = in.nextInt();
            ingredients[i][1] = in.nextInt();
        }

        List<Integer> results = new ArrayList<>();
        powerSet(ingredients,N,includes,0, results);
        results.remove(0);      //적어도 하나의 재료는 들어가야하니 공집합은 없앤다.
        int min = Integer.MAX_VALUE;

        //결과들 중 최솟값
        for(int i : results){
            if(min > i) min = i;
        }

        System.out.println(min);
    }

    //부분집합 구하는 메서드
    private static void powerSet(int[][] arr,int N,boolean[] includes, int idx,List<Integer> results){
        if(idx == N){
            int bitter=0, sour=1;

            for(int i = 0 ; i < idx; i++){
                if(includes[i]) {
                    sour *= arr[i][0];
                    bitter += arr[i][1];
                }
            }

            int temp = Math.abs(sour-bitter);
            results.add(temp);
            return ;
        }
        else {
            includes[idx] = false;
            powerSet(arr,N,includes, idx + 1,results);
            includes[idx] = true;
            powerSet(arr,N,includes, idx + 1,results);
        }
    }
}
//부분집합 재귀함수 구현 참고 https://xmfpes.github.io/algorithm-study/daily-algorithm-07/