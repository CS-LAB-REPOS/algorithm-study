import java.util.Scanner;

public class CuttingCake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cutCount = in.nextInt();
        int posNumber = in.nextInt();
        int[] posNumbers = new int[posNumber + 2];
        int cutCounts[] = new int[cutCount];

        posNumbers[0] = 0;
        posNumbers[posNumber + 1] = in.nextInt();
        for (int i = 1; i <= posNumber; i++) {
            posNumbers[i] = in.nextInt();
        }

        for (int i = 0; i < cutCount; i++) {
            cutCounts[i] = in.nextInt();
        }
        //cutCounts의 수마다 최댓값 구하는 반복문
        for (int i : cutCounts) {
            System.out.println(getMax(posNumbers, i));
        }

    }

    // 제일작은 조각의 최댓값 구하는 반복문
    private static int getMax(int[] posNumbers, int cutcount) {
        int result = 0;     //최댓값
        int[] indexes = new int[cutcount];

        for (int i = 0; i < cutcount; i++) {
            indexes[i] = i + 1;
        }
        result = getMin(indexes,posNumbers);

        //케잌 자르는 모든 경우 구하는 반복문
        while (true) {
            if(indexes[indexes.length-1] == posNumbers.length-1){
                boolean hasNext =next(indexes,posNumbers.length-1,indexes.length-1);
                if(!hasNext) break;
            }
            else {indexes[indexes.length - 1]++;}

            int min = getMin(indexes, posNumbers);
            if (result <= min) result = min;
        }
        return result;
    }

    // 주어진 경우의 조각들 중 길이가 최소인 조각의 길이 구하기.
    private static int getMin(int[] indexes, int[] posNumbers) {
        int result = posNumbers[indexes[0]] - posNumbers[0];
        for(int i = 0; i < indexes.length-1; i ++){
            int temp = posNumbers[indexes[i+1]]-posNumbers[indexes[i]];
            if(result>temp) result = temp;
        }
        int temp  = posNumbers[posNumbers.length-1] - posNumbers[indexes[indexes.length-1]];
        if(result>temp) result =  temp;
        return result;
    }


    //경우 구할 때 필요한 알고리즘
    private static boolean next(int[] indexes, int length, int point) {
        if (point < 0) {
            return false;
        }
        else if (indexes[point] == length) {
            point--;

            return next(indexes, length, point);
        }
        else if (indexes[point] == indexes[point + 1] - 1) {
            point--;

            return next(indexes, length, point);

        }
        else {
            indexes[point]++;
            point++;

            for (; point < indexes.length; point++)
            {
                indexes[point] = indexes[point - 1] + 1;
            }
            return true;
        }
    }
}
