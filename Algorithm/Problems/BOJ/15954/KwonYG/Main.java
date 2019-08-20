import java.util.Scanner;

public class Main {
    static double getM(int selected[]) { // 평균 구하는 함수
        double sum = 0;
        for (int i = 0; i < selected.length; i++) {
            sum += selected[i];
        }
        return sum / selected.length;
    }

    static double bunsan(int selected[], double m) { // 분산 구하는 함수
        double sum = 0;

        for (int i = 0; i < selected.length; i++) {
            sum += (selected[i] - m) * (selected[i] - m);
        }
        return Math.sqrt(sum / selected.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double min = Integer.MAX_VALUE; // 최솟값(정답)

        int N = sc.nextInt();
        int K = sc.nextInt();
        int nums[] = new int[N]; // 인형 선호 수


        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int moreSelectCount = 0; // K개에서 더 선택할 수
        while (K + moreSelectCount <= N) {
            for (int i = 0; i <= N - (K + moreSelectCount); i++) {
                int selected[] = new int[K + moreSelectCount]; // 선택한 인형들 담는 배열
                System.arraycopy(nums, i, selected, 0, K + moreSelectCount); // 인형 선택

                double m = getM(selected); // 평균

                double result = bunsan(selected, m); // 분산

                if (min > result) {
                    min = result;
                }
            }
            moreSelectCount++;
        }
        System.out.println(min);
    }
}