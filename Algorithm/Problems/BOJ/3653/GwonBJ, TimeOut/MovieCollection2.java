import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();        //테스트 케이스 수
        int[][] result = new int[testcase][];       //결과물 저장할 배열


        for(int i = 0; i < testcase; i ++){
            int size = in.nextInt();
            int[] dvdArray = new int[size];
            setDVDLocation(size,dvdArray);
            int count = in.nextInt();
            result[i] = new int[count];

            for(int j = 0; j < count; j++){
                result[i][j]=watchDVD(dvdArray, in.nextInt());
            }
        }
        for(int[] i : result){
            for(int j : i){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }

    //초기 dvdArray 세팅
    private static void setDVDLocation(int number, int[] dvdArray){
        for(int i = 0 ; i < number; i ++){
            dvdArray[i] = i;
        }
    }

    //해당 dvd를 위로 올리고 나머지 dvd를 감소시키는 메서드
    private static int watchDVD(int[] dvdArray, int dvdNumber){
        dvdNumber --;   //배열 인덱스는 0부터 시작하니까 -1
        int upNumber = dvdArray[dvdNumber]; // 해당 dvd의 위에있는 dvd의 개수
        dvdArray[dvdNumber] = 0;
        for(int i = dvdNumber-1; i >= 0; i --){
            System.out.println(dvdArray[i]);
            dvdArray[i]++;
        }
        return upNumber;
    }
}

