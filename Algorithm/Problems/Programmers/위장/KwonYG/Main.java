import java.util.HashMap;

public class Main {
    public static int solution(String[][] clothes) {
        int size = clothes.length;
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        for (int i = 0; i < size; i++) {
            String type = clothes[i][1];
            if (count.containsKey(type)) {
                count.put(clothes[i][1], count.get(clothes[i][1]) + 1);
            } else {
                count.put(clothes[i][1], 2);
            }
        }

        int answer = 1;
        for (int value : count.values()) {
            answer *= value;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }
}

// Reference: https://tallman.tistory.com/7