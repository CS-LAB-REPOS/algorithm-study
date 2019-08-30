import java.util.Scanner;

public class Main {
    public static boolean cutting(int Qi, int distance, int[] rollCake) {
        int now = 0;
        int cnt = 0;
        for (int i = 0; i < rollCake.length; i++) {
            now += rollCake[i];
            if (now >= distance) {
                cnt++;
                now = 0;
            }
        }

        return cnt >= Qi + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int rollCake[] = new int[M + 1];
        for (int i = 0; i < M; i++) {
            rollCake[i] = sc.nextInt();
        }

        rollCake[M] = L;
        for (int i = M; i > 0; i--) { // 자르는 지점 사이 거리 (각 조각 크기)
            rollCake[i] -= rollCake[i - 1];
        }

        // 자르기 시작
        for (int test_case = 0; test_case < N; test_case++) {
            int Qi = sc.nextInt(); // 자를 횟수

            int left = 1, right = L;
            while (right - left > 1) {
                int mid = (left + right) / 2; // 아무리 작아도 롤 케익 크기가 mid 보다는 클 수 있는 지점에서 컷팅
                if (cutting(Qi, mid, rollCake)) {
                    left = mid; // 커팃횟수가 Qi 보다 크면 mid를 늘린다.
                } else right = mid; // 커팅횟수가 Qi보다 작으면 mid를 줄인다.
            }

            System.out.println(left);
        }
    }
    // 참고 reference: https://jeonggyun.tistory.com/223 
}