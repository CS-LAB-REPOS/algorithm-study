import java.util.Scanner;

public class Dolls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double min = Double.MAX_VALUE;     //표준편차
        int[] preference = new int[n];   //선호도 배열
        //배열 초기화
        for (int i = 0; i < preference.length; i++) {
            preference[i] = in.nextInt();
        }
        //  선호하는 사람의 수의 표준편차가 최소가 되는, K개 이상의 연속된 위치에 있는 인형들 구하기.
        for (int i = 0; k + i - 1 < preference.length; i++) {
            int[] preferenceTemp = new int[k + i];
            for (int j = 0; k + j + i - 1 < preference.length; j++) {
                for (int m = j; m < k + j + i; m++) {
                    preferenceTemp[m - j] = preference[m];
                }
                //최솟값 구하기
                if (min > getStandardDeviation(preferenceTemp)) {
                    min = getStandardDeviation(preferenceTemp);
                }
            }
        }
        System.out.println(min);
    }

    // 표준편차 구하는 메서드
    private static double getStandardDeviation(int[] preference) {
        double standardDeviation, distribution = 0, average = 0;

        for (int i : preference) {
            average += i;
        }

        average /= preference.length;
        for (int i : preference) {
            distribution += ((double) i - average) * ((double) i - average);
        }

        distribution /= preference.length;
        standardDeviation = Math.sqrt(distribution);
        return standardDeviation;
    }
}
