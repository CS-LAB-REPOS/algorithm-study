import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> dvds = new LinkedList<>();

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int answer[] = new int[m];
            dvds.clear();
            for (int i = 1; i <= n; i++) {
                dvds.addLast(i);
            }

            for (int i = 1; i <= m; i++) {
                int see = sc.nextInt();
                int position = dvds.indexOf(see);

                answer[i - 1] = position;
                dvds.remove(position);
                dvds.addFirst(see);
            }

            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}