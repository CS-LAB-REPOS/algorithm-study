import java.util.Stack;

public class Main {
    public static int solution(String arrangement) {
        Stack st = new Stack();
        int answer = 0;

        int barCount = 0;
        for(int i = 0; i < arrangement.length(); i++){
            if(arrangement.charAt(i)=='('){
                st.push(arrangement.charAt(i));
                barCount++;
            }else if(arrangement.charAt(i)==')'){
                barCount--;
                st.pop();
                if(arrangement.charAt(i-1)=='('){// 레이저인 경우
                    answer += barCount; // answer + 잘린 막대기 갯수
                }else{ //레이저가 아닌 경우
                    answer += 1; // 제일 위에 막대기 조각만 넣는다.
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String str = "()(((()())(())()))(())";
        System.out.println(solution(str));
    }
}