import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieCollection {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();        //테스트 케이스 수
        int[][] result = new int[testcase][];       //결과물 저장할 배열
        List<DVD> dvdList = new ArrayList<>();      //테스트에 쓸 리스트

        for(int i = 0; i < testcase; i ++){
            setDVDLocation(in.nextInt(),dvdList);
            int count = in.nextInt();
            result[i] = new int[count];

            for(int j = 0; j < count; j++){
                int number = in.nextInt();
                result[i][j]=watchDVD(dvdList, number);
            }
            dvdList = new ArrayList<>();
        }
        for(int[] i : result){
            for(int j : i){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }

    //초기 dvdList 세팅
    private static void setDVDLocation(int number, List<DVD> dvdList ){
        for(int i = 0 ; i < number; i ++){
            DVD dvd = new DVD(i);
            dvdList.add(dvd);
        }
    }

    //해당 dvd를 위로 올리고 나머지 dvd.upNumber를 감소시키는 메서드
    private static int watchDVD(List<DVD> dvdList, int dvdNumber){
        dvdNumber --;   //List 인덱스는 0부터 시작하니까 -1
        int upNumber = dvdList.get(dvdNumber).upNumber;
        dvdList.get(dvdNumber).upNumber =0;
        for(int i = dvdNumber-1; i >= 0; i --){
            dvdList.get(i).increaseUpNumber();
        }
        return upNumber;
    }
}
//DVD 클래스
class DVD{
    int upNumber;       //this.dvd 위에있는 dvd들의 수
    DVD(int upNumber){
        this.upNumber = upNumber;
    }
    void increaseUpNumber(){
        this.upNumber ++;
    }
}